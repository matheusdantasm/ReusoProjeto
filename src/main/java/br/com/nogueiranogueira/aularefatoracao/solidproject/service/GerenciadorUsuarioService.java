package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.TipoUsuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.repository.UsuarioRepository;
import br.com.nogueiranogueira.aularefatoracao.solidproject.strategy.CriacaoUsuarioStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GerenciadorUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final Map<TipoUsuario, CriacaoUsuarioStrategy> strategies;

    public GerenciadorUsuarioService(
            UsuarioRepository usuarioRepository,
            List<CriacaoUsuarioStrategy> strategyList) {

        this.usuarioRepository = usuarioRepository;

        this.strategies = strategyList.stream()
                .collect(Collectors.toMap(
                        CriacaoUsuarioStrategy::getTipo,
                        strategy -> strategy
                ));
    }

    public Usuario criarUsuario(UsuarioDTO dto) {

        TipoUsuario tipo;

        try {
            tipo = TipoUsuario.valueOf(dto.tipo());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo inválido");
        }

        CriacaoUsuarioStrategy strategy = strategies.get(tipo);

        if (strategy == null) {
            throw new IllegalArgumentException("Tipo inválido");
        }

        Usuario usuario = strategy.criar(dto);

        return usuarioRepository.save(usuario);
    }
}
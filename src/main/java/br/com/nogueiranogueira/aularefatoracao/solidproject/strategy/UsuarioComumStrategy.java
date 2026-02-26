package br.com.nogueiranogueira.aularefatoracao.solidproject.strategy;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.TipoUsuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioComumStrategy implements CriacaoUsuarioStrategy {

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.COMUM;
    }

    @Override
    public Usuario criar(UsuarioDTO dto) {

        validarEmail(dto.email());

        Usuario usuario = new Usuario(dto.nome(), dto.email());
        usuario.setPontos(0);

        return usuario;
    }

    private void validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }
}
package br.com.nogueiranogueira.aularefatoracao.solidproject.strategy;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.TipoUsuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.UsuarioVIP;
import org.springframework.stereotype.Service;

@Service
public class UsuarioVipStrategy implements CriacaoUsuarioStrategy {

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.VIP;
    }

    @Override
    public Usuario criar(UsuarioDTO dto) {

        validarEmail(dto.email());
        validarIdade(dto.idade());

        UsuarioVIP usuario = new UsuarioVIP(
                dto.nome(),
                dto.email(),
                true
        );

        usuario.setPontos(100);

        return usuario;
    }

    private void validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }

    private void validarIdade(int idade) {
        if (idade < 18) {
            throw new IllegalArgumentException("Usuário VIP deve ser maior de idade");
        }
    }
}
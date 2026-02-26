package br.com.nogueiranogueira.aularefatoracao.solidproject.strategy;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.TipoUsuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;

public interface CriacaoUsuarioStrategy {

    TipoUsuario getTipo();

    Usuario criar(UsuarioDTO dto);
}
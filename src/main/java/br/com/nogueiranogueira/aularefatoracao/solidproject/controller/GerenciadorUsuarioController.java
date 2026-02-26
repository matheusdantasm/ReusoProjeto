package br.com.nogueiranogueira.aularefatoracao.solidproject.controller;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.service.GerenciadorUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gerenciador/usuarios")
public class GerenciadorUsuarioController {

    private final GerenciadorUsuarioService service;

    public GerenciadorUsuarioController(GerenciadorUsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody UsuarioDTO dto) {
        Usuario usuario = service.criarUsuario(dto);
        return ResponseEntity.ok(usuario);
    }
}

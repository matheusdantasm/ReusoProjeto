package br.com.nogueiranogueira.aularefatoracao.solidproject.repository;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.UsuarioVIP;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GerenciadorUsuarioRepositoryImpl implements GerenciadorUsuarioRepository {

    private final UsuarioRepository usuarioRepository;

    public GerenciadorUsuarioRepositoryImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public void excluir(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public List<Usuario> buscarPorFiltroAvançados(String nome, String email, String tipoUsuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long contarUsuariosPorTipo(String tipoUsuario) {

        if ("VIP".equalsIgnoreCase(tipoUsuario)) {
            return usuarioRepository.countByClass(UsuarioVIP.class);
        }

        if ("COMUM".equalsIgnoreCase(tipoUsuario)) {
            return usuarioRepository.countByClass(Usuario.class)
                    - usuarioRepository.countByClass(UsuarioVIP.class);
        }

        throw new IllegalArgumentException("Tipo inválido");
    }

    @Override
    public List<Object[]> gerarRelatorioUsuariosPorTipo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
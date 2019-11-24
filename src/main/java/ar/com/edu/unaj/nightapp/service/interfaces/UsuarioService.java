package ar.com.edu.unaj.nightapp.service.interfaces;


import ar.com.edu.unaj.nightapp.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> getAll();
    Usuario insert(Usuario usuario);
    Usuario getById(Long id);
    Usuario update(Usuario usuario);
    void removeById(Long id);
}

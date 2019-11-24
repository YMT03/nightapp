package ar.com.edu.unaj.nightapp.service;

import ar.com.edu.unaj.nightapp.dao.UsuarioDAO;
import ar.com.edu.unaj.nightapp.exception.CategoriaNotFoundException;
import ar.com.edu.unaj.nightapp.exception.UsuarioNotFoundException;
import ar.com.edu.unaj.nightapp.model.Usuario;
import ar.com.edu.unaj.nightapp.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la logica respecto a Usuario
 */
@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    /**
     * @return Todas las usuarios.
     */
    @Override
    public List<Usuario> getAll() {
        return (List<Usuario>) usuarioDAO.findAll();
    }

    /**
     * @param usuario
     * @return Usuario creado
     */
    @Override
    public Usuario insert(Usuario usuario) {
        return usuarioDAO.save(usuario);
    }

    /**
     * @param id de la Usuario
     * @return Usuario
     * @throws UsuarioNotFoundException Si no existe
     */
    @Override
    public Usuario getById(Long id) throws UsuarioNotFoundException {
        return usuarioDAO.findById(id).orElseThrow(UsuarioNotFoundException::new);
    }

    /**
     * @param usuario a updatearr
     * @return Usuario updateada
     * @throws CategoriaNotFoundException Si no existia anteriormente p/ evitar insert en update.
     */
    @Override
    public Usuario update(Usuario usuario) throws UsuarioNotFoundException{
        getById(usuario.getId()); //Throw Exception si no existia. Es update no insert.
        return usuarioDAO.save(usuario);
    }

    /**
     * @param id Usuario a eliminar
     * @throws CategoriaNotFoundException si no exister
     */
    @Override
    public void removeById(Long id) throws UsuarioNotFoundException{
        usuarioDAO.delete(getById(id));
    }
}

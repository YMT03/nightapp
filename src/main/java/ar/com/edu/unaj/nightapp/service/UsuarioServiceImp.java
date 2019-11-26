package ar.com.edu.unaj.nightapp.service;

import ar.com.edu.unaj.nightapp.dao.UsuarioDAO;
import ar.com.edu.unaj.nightapp.exception.CategoriaNotFoundException;
import ar.com.edu.unaj.nightapp.exception.UsuarioNotFoundException;
import ar.com.edu.unaj.nightapp.model.Usuario;
import ar.com.edu.unaj.nightapp.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Servicio encargado de la logica respecto a Usuario
 */
@Service
@Transactional
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private EntityManager entityManager;

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
        Query query = entityManager.createNativeQuery("INSERT INTO USUARIOS(ID,USERNAME,PASSWORD,ROL,NOMBRE,APELLIDO,MAIL,MAIL_CONFIRMADO, ACTIVO) VALUES(DEFAULT, :userName, MD5(:password), :rol, :name,:password,:mail,:secureMail,:active)");
        query.setParameter("userName",usuario.getUserName());
        query.setParameter("name",usuario.getNombre());
        query.setParameter("password",usuario.getPassword());
        query.setParameter("rol",usuario.getRol());
        query.setParameter("mail",usuario.getMail());
        query.setParameter("secureMail",usuario.getSecuredMail());
        query.setParameter("active",usuario.getActive());
        query.executeUpdate();

        return usuario;
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

    @Override
    public Usuario findByUserName(String userName) {
        return usuarioDAO.findByUserName(userName);
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

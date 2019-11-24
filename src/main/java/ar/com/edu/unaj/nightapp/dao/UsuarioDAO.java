package ar.com.edu.unaj.nightapp.dao;

import ar.com.edu.unaj.nightapp.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends CrudRepository<Usuario, Long> {
}

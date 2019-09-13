package ar.com.edu.unaj.nightapp.service;

import ar.com.edu.unaj.nightapp.dao.CategoriaDAO;
import ar.com.edu.unaj.nightapp.exception.CategoriaNotFoundException;
import ar.com.edu.unaj.nightapp.model.Categoria;
import ar.com.edu.unaj.nightapp.service.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la logica respecto a Categoria
 */
@Service
public class CategoriaServiceImp implements CategoriaService {

    @Autowired
    private CategoriaDAO categoriaDAO;

    /**
     * @return Todas las categorias. s/paginacion. No se creeria necesario.
     */
    @Override
    public List<Categoria> getAll() {
        return (List<Categoria>) categoriaDAO.findAll();
    }

    /**
     * @param categoria
     * @return Categoria creada
     */
    @Override
    public Categoria insert(Categoria categoria) {
        return categoriaDAO.save(categoria);
    }

    /**
     * @param id de la Categoria
     * @return Categoria
     * @throws CategoriaNotFoundException Si no existe
     */
    @Override
    public Categoria getById(Long id) throws CategoriaNotFoundException{
        return categoriaDAO.findById(id).orElseThrow(CategoriaNotFoundException::new);
    }

    /**
     * @param categoria a updatearr
     * @return Categoria updateada
     * @throws CategoriaNotFoundException Si no existia anteriormente p/ evitar insert en update.
     */
    @Override
    public Categoria update(Categoria categoria) throws CategoriaNotFoundException{
        getById(categoria.getId()); //Throw Exception si no existia. Es update no insert.
        return categoriaDAO.save(categoria);
    }

    /**
     * @param id Categoria a eliminar
     * @throws CategoriaNotFoundException si no exister
     */
    @Override
    public void removeById(Long id) throws CategoriaNotFoundException{
        categoriaDAO.delete(getById(id));
    }
}

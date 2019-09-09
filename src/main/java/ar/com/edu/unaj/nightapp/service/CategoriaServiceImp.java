package ar.com.edu.unaj.nightapp.service;

import ar.com.edu.unaj.nightapp.dao.CategoriaDAO;
import ar.com.edu.unaj.nightapp.exception.CategoriaNotFoundException;
import ar.com.edu.unaj.nightapp.model.Categoria;
import ar.com.edu.unaj.nightapp.service.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImp implements CategoriaService {

    @Autowired
    private CategoriaDAO categoriaDAO;

    @Override
    public List<Categoria> getAll() {
        return (List<Categoria>) categoriaDAO.findAll();
    }

    @Override
    public Categoria insert(Categoria categoria) {
        return categoriaDAO.save(categoria);
    }

    @Override
    public Categoria getById(Long id){
        return categoriaDAO.findById(id).orElseThrow(CategoriaNotFoundException::new);
    }

    @Override
    public Categoria update(Categoria categoria) {
        getById(categoria.getId()); //Throw Exception si no existia. Es update no insert.
        return categoriaDAO.save(categoria);
    }

    @Override
    public void removeById(Long id) {
        categoriaDAO.delete(getById(id));
    }
}

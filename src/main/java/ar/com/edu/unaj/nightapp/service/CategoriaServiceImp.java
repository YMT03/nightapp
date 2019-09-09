package ar.com.edu.unaj.nightapp.service;

import ar.com.edu.unaj.nightapp.dao.CategoriaDAO;
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
}

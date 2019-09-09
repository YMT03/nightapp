package ar.com.edu.unaj.nightapp.service.interfaces;


import ar.com.edu.unaj.nightapp.model.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> getAll();
    Categoria insert(Categoria categoria);
    Categoria getById(Long id);
    Categoria update(Categoria categoria);
    void removeById(Long id);

}

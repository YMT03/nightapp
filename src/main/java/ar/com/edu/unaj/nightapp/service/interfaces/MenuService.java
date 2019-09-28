package ar.com.edu.unaj.nightapp.service.interfaces;


import ar.com.edu.unaj.nightapp.model.Categoria;
import ar.com.edu.unaj.nightapp.model.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getAll();
    Menu insert(Menu menu);
    Menu getById(Long id);
    Menu update(Menu menu);
    void removeById(Long id);
}

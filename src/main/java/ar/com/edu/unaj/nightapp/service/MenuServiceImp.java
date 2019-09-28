package ar.com.edu.unaj.nightapp.service;

import ar.com.edu.unaj.nightapp.dao.CategoriaDAO;
import ar.com.edu.unaj.nightapp.dao.MenuDAO;
import ar.com.edu.unaj.nightapp.exception.CategoriaNotFoundException;
import ar.com.edu.unaj.nightapp.exception.MenuNotFoundException;
import ar.com.edu.unaj.nightapp.model.Categoria;
import ar.com.edu.unaj.nightapp.model.Menu;
import ar.com.edu.unaj.nightapp.service.interfaces.CategoriaService;
import ar.com.edu.unaj.nightapp.service.interfaces.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la logica respecto a Menu
 */
@Service
public class MenuServiceImp implements MenuService {

    @Autowired
    private MenuDAO menuDAO;

    /**
     * @return Todos los menu. s/paginacion. No se creeria necesario.
     */
    @Override
    public List<Menu> getAll() {
        return (List<Menu>) menuDAO.findAll();
    }

    /**
     * @param menu
     * @return Menu creado
     */
    @Override
    public Menu insert(Menu menu) {
        return menuDAO.save(menu);
    }

    /**
     * @param id del Menu
     * @return Menu
     * @throws ar.com.edu.unaj.nightapp.exception.MenuNotFoundException Si no existe
     */
    @Override
    public Menu getById(Long id) throws MenuNotFoundException {
        return menuDAO.findById(id).orElseThrow(MenuNotFoundException::new);
    }

    /**
     * @param menu a updatear
     * @return Menu updateado
     * @throws MenuNotFoundException Si no existia anteriormente p/ evitar insert en update.
     */
    @Override
    public Menu update(Menu menu) throws MenuNotFoundException{
        getById(menu.getId()); //Throw Exception si no existia. Es update no insert.
        return menuDAO.save(menu);
    }

    /**
     * @param id Menu a eliminar
     * @throws MenuNotFoundException si no exister
     */
    @Override
    public void removeById(Long id) throws MenuNotFoundException{
        menuDAO.delete(getById(id));
    }
}

package ar.com.edu.unaj.nightapp.endpoint.mapper;

import ar.com.edu.unaj.nightapp.endpoint.dto.MenuDTO;
import ar.com.edu.unaj.nightapp.model.Menu;
import org.springframework.stereotype.Component;

@Component
public class MenuMapper implements Mapper<Menu, MenuDTO> {

    @Override
    public MenuDTO mapToDTO(Menu bo) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(bo.getId());
        menuDTO.setNombre(bo.getNombre());
        return menuDTO;
    }

    @Override
    public Menu mapToBO(MenuDTO dto) {
        Menu menu = new Menu();
        menu.setId(dto.getId());
        menu.setNombre(dto.getNombre());
        return menu;
    }
}

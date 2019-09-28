package ar.com.edu.unaj.nightapp.endpoint;

import ar.com.edu.unaj.nightapp.endpoint.dto.MenuDTO;
import ar.com.edu.unaj.nightapp.endpoint.mapper.MenuMapper;
import ar.com.edu.unaj.nightapp.service.interfaces.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app/menus")
public class MenuEndpoint {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuMapper menuMapper;

    @GetMapping
    public List<MenuDTO> getAll(){
        return menuService.getAll().stream().map(x->menuMapper.mapToDTO(x)).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public MenuDTO getById(@PathVariable Long id){
        return menuMapper.mapToDTO(menuService.getById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity removeById(@PathVariable Long id){
        menuService.removeById(id);
        return ResponseEntity.ok("");
    }

    @PostMapping
    public MenuDTO insert(@RequestBody @Valid MenuDTO menuDTO){
        return menuMapper.mapToDTO(menuService.insert(menuMapper.mapToBO(menuDTO)));
    }

    @PutMapping
    public MenuDTO modify(@RequestBody @Valid MenuDTO menuDTO){
        return menuMapper.mapToDTO(menuService.update(menuMapper.mapToBO(menuDTO)));
    }

}

package ar.com.edu.unaj.nightapp.endpoint;

import ar.com.edu.unaj.nightapp.endpoint.dto.UsuarioDTO;
import ar.com.edu.unaj.nightapp.endpoint.mapper.UsuarioMapper;
import ar.com.edu.unaj.nightapp.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app/usuarios")
public class UsuarioEndpoint {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @GetMapping
    public List<UsuarioDTO> getAll(){
        return usuarioService.getAll().stream().map(x->usuarioMapper.mapToDTO(x)).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public UsuarioDTO getById(@PathVariable Long id){
        return usuarioMapper.mapToDTO(usuarioService.getById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity removeById(@PathVariable Long id){
        usuarioService.removeById(id);
        return ResponseEntity.ok("");
    }

    @PostMapping
    public UsuarioDTO insert(@RequestBody @Valid UsuarioDTO usuarioDTO){
        return usuarioMapper.mapToDTO(usuarioService.insert(usuarioMapper.mapToBO(usuarioDTO)));
    }

    @PutMapping
    public UsuarioDTO modify(@RequestBody @Valid UsuarioDTO usuarioDTO){
        return usuarioMapper.mapToDTO(usuarioService.update(usuarioMapper.mapToBO(usuarioDTO)));
    }

}

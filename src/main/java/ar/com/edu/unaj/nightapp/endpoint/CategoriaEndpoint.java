package ar.com.edu.unaj.nightapp.endpoint;

import ar.com.edu.unaj.nightapp.endpoint.dto.CategoriaDTO;
import ar.com.edu.unaj.nightapp.endpoint.mapper.CategoriaMapper;
import ar.com.edu.unaj.nightapp.service.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app/categorias")
public class CategoriaEndpoint {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @GetMapping
    public List<CategoriaDTO> getAll(){
        return categoriaService.getAll().stream().map(x->categoriaMapper.mapToDTO(x)).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public CategoriaDTO getById(@PathVariable Long id){
        return categoriaMapper.mapToDTO(categoriaService.getById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity removeById(@PathVariable Long id){
        categoriaService.removeById(id);
        return ResponseEntity.ok("");
    }

    @PostMapping
    public CategoriaDTO insert(@RequestBody @Valid CategoriaDTO categoriaDTO){
        return categoriaMapper.mapToDTO(categoriaService.insert(categoriaMapper.mapToBO(categoriaDTO)));
    }

    @PutMapping
    public CategoriaDTO modify(@RequestBody @Valid CategoriaDTO categoriaDTO){
        return categoriaMapper.mapToDTO(categoriaService.update(categoriaMapper.mapToBO(categoriaDTO)));
    }

}

package ar.com.edu.unaj.nightapp.endpoint;

import ar.com.edu.unaj.nightapp.endpoint.dto.CiudadDTO;
import ar.com.edu.unaj.nightapp.endpoint.mapper.CiudadMapper;
import ar.com.edu.unaj.nightapp.service.interfaces.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app/ciudades")
public class CiudadEndpoint {

    @Autowired
    private CiudadService ciudadService;

    @Autowired
    private CiudadMapper ciudadMapper;

    @GetMapping
    public List<CiudadDTO> getAll(){
        return ciudadService.getAll().stream().map(x->ciudadMapper.mapToDTO(x)).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public CiudadDTO getById(@PathVariable Long id){
        return ciudadMapper.mapToDTO(ciudadService.getById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity removeById(@PathVariable Long id){
        ciudadService.removeById(id);
        return ResponseEntity.ok("");
    }

    @PostMapping
    public CiudadDTO insert(@RequestBody @Valid CiudadDTO ciudadDTO){
        return ciudadMapper.mapToDTO(ciudadService.insert(ciudadMapper.mapToBO(ciudadDTO)));
    }

    @PutMapping
    public CiudadDTO modify(@RequestBody @Valid CiudadDTO ciudadDTO){
        return ciudadMapper.mapToDTO(ciudadService.update(ciudadMapper.mapToBO(ciudadDTO)));
    }
}

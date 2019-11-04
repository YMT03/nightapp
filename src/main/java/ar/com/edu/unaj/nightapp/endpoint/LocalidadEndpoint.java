package ar.com.edu.unaj.nightapp.endpoint;

import ar.com.edu.unaj.nightapp.endpoint.dto.CiudadDTO;
import ar.com.edu.unaj.nightapp.endpoint.dto.LocalidadDTO;
import ar.com.edu.unaj.nightapp.endpoint.mapper.CiudadMapper;
import ar.com.edu.unaj.nightapp.endpoint.mapper.LocalidadMapper;
import ar.com.edu.unaj.nightapp.model.Localidad;
import ar.com.edu.unaj.nightapp.service.interfaces.CiudadService;
import ar.com.edu.unaj.nightapp.service.interfaces.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app/localidades")
public class LocalidadEndpoint {

    @Autowired
    private LocalidadService localidadService;

    @Autowired
    private CiudadService ciudadService;

    @Autowired
    private CiudadMapper ciudadMapper;

    @Autowired
    private LocalidadMapper localidadMapper;

    @GetMapping
    public List<LocalidadDTO> getAll(){
        return localidadService.getAll().stream().map(x->localidadMapper.mapToDTO(x)).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public LocalidadDTO getById(@PathVariable Long id){
        return localidadMapper.mapToDTO(localidadService.getById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity removeById(@PathVariable Long id){
        localidadService.removeById(id);
        return ResponseEntity.ok("");
    }

    @PostMapping
    public LocalidadDTO insert(@RequestBody @Valid LocalidadDTO categoriaDTO){
        return localidadMapper.mapToDTO(localidadService.insert(localidadMapper.mapToBO(categoriaDTO)));
    }

    @GetMapping("{id}/ciudades")
    public List<CiudadDTO> getAllCiudades(@PathVariable Long id){
        return ciudadService.getAllFromLocalidadId(id).stream().map(x->ciudadMapper.mapToDTO(x)).collect(Collectors.toList());
    }

    @PutMapping
    public LocalidadDTO modify(@RequestBody @Valid LocalidadDTO categoriaDTO){
        return localidadMapper.mapToDTO(localidadService.update(localidadMapper.mapToBO(categoriaDTO)));
    }
}

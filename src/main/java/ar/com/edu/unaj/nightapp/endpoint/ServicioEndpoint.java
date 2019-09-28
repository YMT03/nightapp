package ar.com.edu.unaj.nightapp.endpoint;

import ar.com.edu.unaj.nightapp.endpoint.dto.ServicioDTO;
import ar.com.edu.unaj.nightapp.endpoint.mapper.ServicioMapper;
import ar.com.edu.unaj.nightapp.service.interfaces.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app/servicios")
public class ServicioEndpoint {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private ServicioMapper servicioMapper;

    @GetMapping
    public List<ServicioDTO> getAll(){
        return servicioService.getAll().stream().map(x->servicioMapper.mapToDTO(x)).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ServicioDTO getById(@PathVariable Long id){
        return servicioMapper.mapToDTO(servicioService.getById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity removeById(@PathVariable Long id){
        servicioService.removeById(id);
        return ResponseEntity.ok("");
    }

    @PostMapping
    public ServicioDTO insert(@RequestBody @Valid ServicioDTO servicioDTO){
        return servicioMapper.mapToDTO(servicioService.insert(servicioMapper.mapToBO(servicioDTO)));
    }

    @PutMapping
    public ServicioDTO modify(@RequestBody @Valid ServicioDTO servicioDTO){
        return servicioMapper.mapToDTO(servicioService.update(servicioMapper.mapToBO(servicioDTO)));
    }

}

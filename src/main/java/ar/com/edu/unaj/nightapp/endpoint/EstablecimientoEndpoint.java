package ar.com.edu.unaj.nightapp.endpoint;

import ar.com.edu.unaj.nightapp.endpoint.dto.EstablecimientoDTO;
import ar.com.edu.unaj.nightapp.endpoint.dto.EstablecimientoMapper;
import ar.com.edu.unaj.nightapp.service.interfaces.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/app/establecimientos")
public class EstablecimientoEndpoint {

    @Autowired
    private EstablecimientoService establecimientoService;

    @Autowired
    private EstablecimientoMapper establecimientoMapper;

    @GetMapping
    @ResponseBody
    public List<EstablecimientoDTO> getAll(){
        return establecimientoService.getAll().stream().map(x->establecimientoMapper.mapToDTO(x)).collect(Collectors.toList());
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity removeById(@PathVariable Long id) throws Exception {
        establecimientoService.removeById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<EstablecimientoDTO> getById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(establecimientoMapper.mapToDTO(establecimientoService.getById(id)));
    }




}

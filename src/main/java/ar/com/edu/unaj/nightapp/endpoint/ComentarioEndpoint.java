package ar.com.edu.unaj.nightapp.endpoint;

import ar.com.edu.unaj.nightapp.endpoint.dto.ComentarioDTO;
import ar.com.edu.unaj.nightapp.endpoint.mapper.ComentarioMapper;
import ar.com.edu.unaj.nightapp.exception.ComentarioNotFoundException;
import ar.com.edu.unaj.nightapp.model.Comentario;
import ar.com.edu.unaj.nightapp.model.Establecimiento;
import ar.com.edu.unaj.nightapp.service.interfaces.ComentarioService;
import ar.com.edu.unaj.nightapp.service.interfaces.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app/establecimientos/{id}/comentarios")
public class ComentarioEndpoint {

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private ComentarioMapper comentarioMapper;

    @Autowired
    private EstablecimientoService establecimientoService;

    @GetMapping("{comentarioId}")
    public ResponseEntity<ComentarioDTO> getById(@PathVariable Long comentarioId, @PathVariable Long id){
        return ResponseEntity.ok(comentarioMapper.mapToDTO(comentarioService.getById(id, comentarioId)));
    }

    @GetMapping
    public List<ComentarioDTO> getAll(@RequestParam(defaultValue = "0") Integer offset,
                                      @RequestParam(defaultValue = "10") Integer size,
                                      @PathVariable Long id){
        establecimientoService.getById(id);//Throw Exception si no existe
        size=size>30?30:size;
        return comentarioService.getAll(id, offset, size).stream().map(x->comentarioMapper.mapToDTO(x)).collect(Collectors.toList());
    }

    @PostMapping
    public ComentarioDTO insert(@RequestBody @Valid ComentarioDTO comentarioDTO, @PathVariable Long id){
        Establecimiento establecimiento = establecimientoService.getById(id); //Si no existe Exception
        Comentario comentario = comentarioMapper.mapToBO(comentarioDTO);
        comentario.setEstablecimiento(establecimiento);
        return comentarioMapper.mapToDTO(comentarioService.insert(comentario));
    }

    @DeleteMapping("{comentarioId}")
    public ResponseEntity removeById(@PathVariable Long comentarioId, @PathVariable Long id){
        comentarioService.removeById(id, comentarioId);
        return ResponseEntity.ok("");
    }

}

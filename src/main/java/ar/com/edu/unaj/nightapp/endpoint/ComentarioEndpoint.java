package ar.com.edu.unaj.nightapp.endpoint;

import ar.com.edu.unaj.nightapp.endpoint.dto.ComentarioDTO;
import ar.com.edu.unaj.nightapp.endpoint.mapper.ComentarioMapper;
import ar.com.edu.unaj.nightapp.service.interfaces.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app/establecimientos/{id}/comentarios")
public class ComentarioEndpoint {

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private ComentarioMapper comentarioMapper;

    @GetMapping
    public List<ComentarioDTO> getAll(@RequestParam(defaultValue = "0") Integer offset,
                                      @RequestParam(defaultValue = "10") Integer size,
                                      @PathVariable Long id){
        size=size>30?30:size;
        return comentarioService.getAll(id, offset, size).stream().map(x->comentarioMapper.mapToDTO(x)).collect(Collectors.toList());
    }

}

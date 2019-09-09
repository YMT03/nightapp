package ar.com.edu.unaj.nightapp.endpoint;

import ar.com.edu.unaj.nightapp.endpoint.dto.CategoriaDTO;
import ar.com.edu.unaj.nightapp.endpoint.mapper.CategoriaMapper;
import ar.com.edu.unaj.nightapp.service.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController("/app/categorias")
public class CategoriaEndpoint {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @GetMapping
    public List<CategoriaDTO> getAll(){
        return categoriaService.getAll().stream().map(x->categoriaMapper.mapToDTO(x)).collect(Collectors.toList());
    }

}

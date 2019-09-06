package ar.com.edu.unaj.nightapp.endpoint;

import ar.com.edu.unaj.nightapp.endpoint.dto.EstablecimientoDTO;
import ar.com.edu.unaj.nightapp.service.interfaces.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/app/establecimientos")
public class EstablecimientoEndpoint {

    @Autowired
    private EstablecimientoService establecimientoService;

    @GetMapping
    @ResponseBody
    public List<EstablecimientoDTO> getAll(){
        return establecimientoService.getAll().stream().map(x->new EstablecimientoDTO(x.getNombre())).collect(Collectors.toList());
    }



}

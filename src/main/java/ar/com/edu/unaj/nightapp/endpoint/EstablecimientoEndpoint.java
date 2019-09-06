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

/**
 * Controlador encargado de todos los Endpoints en las URLS del tipo /app/establecimientos
 */
@Controller
@RequestMapping("/app/establecimientos")
public class EstablecimientoEndpoint {

    @Autowired
    private EstablecimientoService establecimientoService;

    @Autowired
    private EstablecimientoMapper establecimientoMapper;

    /**
     * @return Todos los establecimientos en DB. Sin paginacion ni ningun tipo de filtro. TODO Peligroso enviar todos con mucha cantidad de registros. A futuro -> Paginacion
     */
    @GetMapping
    @ResponseBody
    public List<EstablecimientoDTO> getAll(){
        return establecimientoService.getAll().stream().map(x->establecimientoMapper.mapToDTO(x)).collect(Collectors.toList());
    }

    /**
     * @param id El id del Establecimiento a eliminar
     * @return 200 OK Http Status en caso de que sea correcto. TODO A verificar el error por defecto
     * @throws Exception Envia una Excepcion del tipo Exception TODO A modificar la Excepcion enviada. A futuro -> No Exception generica sino la particular con el mensaje y Http Status requerido.
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity removeById(@PathVariable Long id) throws Exception {
        establecimientoService.removeById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * @param id El id del Establecimiento a visualizar
     * @return EstablecimientoDTO asociado y 200 OK Http Status en caso de que sea correcto. TODO A verificar el error en caso de no existir
     * @throws Exception Envia una Excepcion del tipo Exception TODO A modificar la Excepcion enviada. A futuro -> No Exception generica sino la particular con el mensaje y Http Status requerido.
     */
    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<EstablecimientoDTO> getById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(establecimientoMapper.mapToDTO(establecimientoService.getById(id)));
    }




}

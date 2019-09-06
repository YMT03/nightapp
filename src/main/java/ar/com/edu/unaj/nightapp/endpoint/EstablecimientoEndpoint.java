package ar.com.edu.unaj.nightapp.endpoint;

import ar.com.edu.unaj.nightapp.endpoint.dto.EstablecimientoDTO;
import ar.com.edu.unaj.nightapp.endpoint.dto.EstablecimientoMapper;
import ar.com.edu.unaj.nightapp.service.interfaces.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    /**
     * Crea un nuevo Establecimiento
     * @param establecimientoDTO TODO Posiblemente se requiera especializar el EstablecimientoDTO con @Valid y validar campos
     * @return 201 CREATED. TODO Verificar Exception en parseo/ insert datos no nulleables. Distincion, no es  500 si esta mal el Request param.
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<EstablecimientoDTO> insert(@RequestBody EstablecimientoDTO establecimientoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(establecimientoMapper.mapToDTO(establecimientoService.insert(establecimientoMapper.toModel(establecimientoDTO))));
    }

    /**
     * @param establecimientoDTO
     * @return Establecimiento actualizado
     * @throws Exception TODO Diferenciar. La Excepcion es para el caso de que no exista un establecimiento con ese ID. *No seria update sino insert. No se utilizara la misma entrada
     */
    @PutMapping
    @ResponseBody
    public ResponseEntity<EstablecimientoDTO> modify(@RequestBody EstablecimientoDTO establecimientoDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(establecimientoMapper.mapToDTO(establecimientoService.update(establecimientoMapper.toModel(establecimientoDTO))));
    }




}

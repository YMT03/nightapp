package ar.com.edu.unaj.nightapp.endpoint;

import ar.com.edu.unaj.nightapp.endpoint.dto.EstablecimientoDTO;
import ar.com.edu.unaj.nightapp.endpoint.dto.FiltroDTO;
import ar.com.edu.unaj.nightapp.endpoint.mapper.EstablecimientoMapper;
import ar.com.edu.unaj.nightapp.exception.EstablecimientoNotFoundException;
import ar.com.edu.unaj.nightapp.service.interfaces.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
     * @param offset Desplazamiento inicial de paginas. Por default arranca en posicion 0.
     * @param size Cantidad de rows por pagina. Por default son 20 objectos por pagina. Limitado a un maximo de 50.
     * @param name   Para filtrar por nombre
     * @return Todos los establecimientos en DB. Con paginacion y filtrados por nombre en caso de
     */
    @GetMapping
    @ResponseBody
    public List<EstablecimientoDTO> getAll(@RequestParam(defaultValue = "0") Integer offset,
                                           @RequestParam(defaultValue = "20") Integer size,
                                           @RequestParam(defaultValue = "") String name){
        size=size>50?50:size;
        return establecimientoService.getAllPaginatedByNameContaining(offset, size, name).stream().map(x->establecimientoMapper.mapToDTO(x)).collect(Collectors.toList());
    }

    /**
     * @param id El id del Establecimiento a eliminar
     * @return 200 OK Http Status en caso de que sea correcto. Sino 404
     * @throws EstablecimientoNotFoundException Envia una Excepcion del tipo EstablecimientoNotFoundException 404 http code
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity removeById(@PathVariable Long id) throws EstablecimientoNotFoundException {
        establecimientoService.removeById(id);
        return ResponseEntity.ok("");
    }

    /**
     * @param id El id del Establecimiento a visualizar
     * @return EstablecimientoDTO asociado y 200 OK Http Status en caso de que sea correcto.
     * @throws EstablecimientoNotFoundException
     */
    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<EstablecimientoDTO> getById(@PathVariable Long id) throws EstablecimientoNotFoundException {
        return ResponseEntity.ok(establecimientoMapper.mapToDTO(establecimientoService.getById(id)));
    }

    /**
     * Crea un nuevo Establecimiento
     * @param establecimientoDTO
     * @return 201 CREATED.
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<EstablecimientoDTO> insert(@RequestBody @Valid EstablecimientoDTO establecimientoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(establecimientoMapper.mapToDTO(establecimientoService.insert(establecimientoMapper.mapToBO(establecimientoDTO))));
    }

    /**
     * @param establecimientoDTO
     * @return Establecimiento actualizado
     * @throws EstablecimientoNotFoundException http code 404
     */
    @PutMapping
    @ResponseBody
    public ResponseEntity<EstablecimientoDTO> modify(@RequestBody @Valid EstablecimientoDTO establecimientoDTO) throws EstablecimientoNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(establecimientoMapper.mapToDTO(establecimientoService.update(establecimientoMapper.mapToBO(establecimientoDTO))));
    }

    @PostMapping("/filtrados")
    @ResponseBody
    public List<EstablecimientoDTO> insert(@RequestBody @Valid FiltroDTO filtroDTO, @RequestParam(defaultValue = "0") Integer offset,
                                            @RequestParam(defaultValue = "20") Integer size){
        size=size>50?50:size;
        //SecurityContextHolder.getContext().getAuthentication(); USUARIO LOGGEADO
        return establecimientoService.getAllPaginatedAndFiltered(offset,size,filtroDTO).stream().map(x->establecimientoMapper.mapToDTO(x)).collect(Collectors.toList());
    }



}

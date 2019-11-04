package ar.com.edu.unaj.nightapp.endpoint.mapper;

import ar.com.edu.unaj.nightapp.endpoint.dto.EstablecimientoDTO;
import ar.com.edu.unaj.nightapp.model.Establecimiento;
import ar.com.edu.unaj.nightapp.model.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Componente encargado de la logica de mappeo entre Objeto @Establecimiento y @EstablecimientoDTO
 */
@Component
public class EstablecimientoMapper implements Mapper<Establecimiento,EstablecimientoDTO> {

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private ServicioMapper servicioMapper;

    @Autowired
    private ComentarioMapper comentarioMapper;

    @Autowired
    private UbicacionMapper ubicacionMapper;
    /**
     * Mappea un Establecimiento a EstablecimientoDTO. BO a Vista.
     *
     * @param establecimiento
     * @return establecimientoDTO
     */
    public EstablecimientoDTO mapToDTO(Establecimiento establecimiento){
        EstablecimientoDTO establecimientoDTO = new EstablecimientoDTO();
        establecimientoDTO.setId(establecimiento.getId());
        establecimientoDTO.setNombre(establecimiento.getNombre());
        establecimientoDTO.setDescripcion(establecimiento.getDescripcion());
        establecimientoDTO.setActivo(establecimiento.getActivo());
        establecimientoDTO.setDireccion(establecimiento.getUbicacion().getDireccion());
        establecimientoDTO.setCiudad(establecimiento.getUbicacion().getCiudad().getNombre());
        if(establecimiento.getComentarios()!=null && !establecimiento.getComentarios().isEmpty())
            establecimientoDTO.setComentarioDTOS(establecimiento.getComentarios().stream().map(x->comentarioMapper.mapToDTO(x)).collect(Collectors.toList()));
        if(establecimiento.getCategorias()!=null && !establecimiento.getCategorias().isEmpty())
        establecimientoDTO.setCategorias(establecimiento.getCategorias().stream().map(x->categoriaMapper.mapToDTO(x)).collect(Collectors.toList()));
        if(establecimiento.getServicios()!=null && !establecimiento.getServicios().isEmpty())
            establecimientoDTO.setServicioDTOS(establecimiento.getServicios().stream().map(x->servicioMapper.mapToDTO(x)).collect(Collectors.toList()));
        establecimientoDTO.setRating(establecimiento.getRating());
        return establecimientoDTO;
    }

    /**
     * Mappea un EstablecimientoDTO a Establecimiento. Vista a BO.
     *
     * @param establecimientoDTO
     * @return EstablecimientoBO
     */
    public Establecimiento mapToBO(EstablecimientoDTO establecimientoDTO){
        Establecimiento establecimiento = new Establecimiento();
        Ubicacion ubicacion = new Ubicacion();
        establecimiento.setUbicacion(ubicacion);
        establecimiento.setId(establecimientoDTO.getId());
        establecimiento.setNombre(establecimientoDTO.getNombre());
        establecimiento.setDescripcion(establecimientoDTO.getDescripcion());
        establecimiento.setActivo(establecimientoDTO.getActivo());
        establecimiento.setRating(establecimientoDTO.getRating());
        return establecimiento;
    }

    @Override
    public EstablecimientoDTO mapToDTO(Establecimiento establecimiento, boolean eager) {
        EstablecimientoDTO establecimientoDTO = new EstablecimientoDTO();
        establecimientoDTO.setId(establecimiento.getId());
        establecimientoDTO.setNombre(establecimiento.getNombre());
        establecimientoDTO.setDescripcion(establecimiento.getDescripcion());
        establecimientoDTO.setActivo(establecimiento.getActivo());
        establecimientoDTO.setRating(establecimiento.getRating());
        return establecimientoDTO;
    }
}

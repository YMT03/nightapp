package ar.com.edu.unaj.nightapp.endpoint.mapper;

import ar.com.edu.unaj.nightapp.endpoint.dto.EstablecimientoDTO;
import ar.com.edu.unaj.nightapp.model.Establecimiento;
import ar.com.edu.unaj.nightapp.model.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Componente encargado de la logica de mappeo entre Objeto @Establecimiento y @EstablecimientoDTO
 */
@Component
public class EstablecimientoMapper implements Mapper<Establecimiento,EstablecimientoDTO> {


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
        if(establecimiento.getUbicacion()!=null)
            establecimientoDTO.setUbicacionDTO(ubicacionMapper.mapToDTO(establecimiento.getUbicacion()));
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
        if(establecimientoDTO.getUbicacionDTO()!=null)
            establecimiento.setUbicacion(ubicacionMapper.mapToBO(establecimientoDTO.getUbicacionDTO()));
        return establecimiento;
    }



}

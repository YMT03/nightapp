package ar.com.edu.unaj.nightapp.endpoint.dto;

import ar.com.edu.unaj.nightapp.model.Establecimiento;
import org.springframework.stereotype.Component;

/**
 * Componente encargado de la logica de mappeo entre Objeto @Establecimiento y @EstablecimientoDTO
 */
@Component
public class EstablecimientoMapper {


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
        return establecimientoDTO;
    }

    /**
     * Mappea un EstablecimientoDTO a Establecimiento. Vista a BO.
     *
     * @param establecimientoDTO
     * @return EstablecimientoBO
     */
    public Establecimiento toModel(EstablecimientoDTO establecimientoDTO){
        Establecimiento establecimiento = new Establecimiento();
        establecimiento.setId(establecimientoDTO.getId());
        establecimiento.setNombre(establecimientoDTO.getNombre());
        return establecimiento;
    }



}

package ar.com.edu.unaj.nightapp.endpoint.mapper;

import ar.com.edu.unaj.nightapp.endpoint.dto.UbicacionDTO;
import ar.com.edu.unaj.nightapp.model.Ubicacion;
import org.springframework.stereotype.Component;

/**
 * Componente encargado de la logica de mappeo entre Objeto @Ubicacion y @UbicacionDTO
 */

@Component
public class UbicacionMapper implements Mapper<Ubicacion, UbicacionDTO>{

    /**
     * Mappea un Ubicacion a UbicacionDTO. BO a Vista.
     *
     * @param bo ubicacion
     * @return ubicacionDTO
     */

    @Override
    public UbicacionDTO mapToDTO(Ubicacion bo) {
        UbicacionDTO ubicacionDTO = new UbicacionDTO();
        ubicacionDTO.setDireccion(bo.getDireccion());
        ubicacionDTO.setLatitud(bo.getLatitud());
        ubicacionDTO.setLongitud(bo.getLongitud());
        ubicacionDTO.setId(bo.getId());
        return ubicacionDTO;
    }

    /**
     * Mappea un UbicacionDTO a Ubicacion. Vista a BO.
     *
     * @param dto UbicacionDTO
     * @return Ubicacion
     */

    @Override
    public Ubicacion mapToBO(UbicacionDTO dto) {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setDireccion(dto.getDireccion());
        ubicacion.setId(dto.getId());
        ubicacion.setLatitud(dto.getLatitud());
        ubicacion.setLongitud(dto.getLongitud());
        return ubicacion;
    }
}

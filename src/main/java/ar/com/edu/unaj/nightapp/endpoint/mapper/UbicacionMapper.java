package ar.com.edu.unaj.nightapp.endpoint.mapper;

import ar.com.edu.unaj.nightapp.endpoint.dto.UbicacionDTO;
import ar.com.edu.unaj.nightapp.model.Ubicacion;
import org.springframework.stereotype.Component;

@Component
public class UbicacionMapper implements Mapper<Ubicacion, UbicacionDTO>{

    @Override
    public UbicacionDTO mapToDTO(Ubicacion bo) {
        UbicacionDTO ubicacionDTO = new UbicacionDTO();
        ubicacionDTO.setDireccion(bo.getDireccion());
        ubicacionDTO.setLatitud(bo.getLatitud());
        ubicacionDTO.setLongitud(bo.getLongitud());
        ubicacionDTO.setId(bo.getId());
        return ubicacionDTO;
    }

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

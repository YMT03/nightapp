package ar.com.edu.unaj.nightapp.endpoint.mapper;

import ar.com.edu.unaj.nightapp.endpoint.dto.ServicioDTO;
import ar.com.edu.unaj.nightapp.model.Servicio;
import org.springframework.stereotype.Component;

@Component
public class ServicioMapper implements Mapper<Servicio, ServicioDTO> {

    @Override
    public ServicioDTO mapToDTO(Servicio bo) {
        ServicioDTO servicioDTO = new ServicioDTO();
        servicioDTO.setId(bo.getId());
        servicioDTO.setNombre(bo.getNombre());
        return servicioDTO;
    }

    @Override
    public Servicio mapToBO(ServicioDTO dto) {
        Servicio servicio = new Servicio();
        servicio.setId(dto.getId());
        servicio.setNombre(dto.getNombre());
        return servicio;
    }
}

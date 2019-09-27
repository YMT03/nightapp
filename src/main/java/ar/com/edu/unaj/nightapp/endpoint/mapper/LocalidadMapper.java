package ar.com.edu.unaj.nightapp.endpoint.mapper;

import ar.com.edu.unaj.nightapp.endpoint.dto.LocalidadDTO;
import ar.com.edu.unaj.nightapp.model.Localidad;
import org.springframework.stereotype.Component;

@Component
public class LocalidadMapper implements Mapper<Localidad, LocalidadDTO> {

    @Override
    public LocalidadDTO mapToDTO(Localidad bo) {
        return new LocalidadDTO(bo.getId(),bo.getNombre());
    }

    @Override
    public Localidad mapToBO(LocalidadDTO dto) {
        return new Localidad(dto.getId(), dto.getNombre());
    }
}

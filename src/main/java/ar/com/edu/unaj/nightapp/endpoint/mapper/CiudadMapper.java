package ar.com.edu.unaj.nightapp.endpoint.mapper;

import ar.com.edu.unaj.nightapp.endpoint.dto.CiudadDTO;
import ar.com.edu.unaj.nightapp.endpoint.dto.LocalidadDTO;
import ar.com.edu.unaj.nightapp.model.Ciudad;
import ar.com.edu.unaj.nightapp.model.Localidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CiudadMapper implements Mapper<Ciudad, CiudadDTO> {

    @Autowired
    private LocalidadMapper localidadMapper;

    @Override
    public CiudadDTO mapToDTO(Ciudad bo) {
        return new CiudadDTO(bo.getId(),bo.getNombre(),localidadMapper.mapToDTO(bo.getLocalidad()));
    }

    @Override
    public Ciudad mapToBO(CiudadDTO dto) {
        return new Ciudad(dto.getId(), dto.getNombre(), localidadMapper.mapToBO(dto.getLocalidadDTO()));
    }
}

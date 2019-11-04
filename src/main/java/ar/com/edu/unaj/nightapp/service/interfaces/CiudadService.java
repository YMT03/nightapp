package ar.com.edu.unaj.nightapp.service.interfaces;

import ar.com.edu.unaj.nightapp.exception.CiudadNotFoundException;
import ar.com.edu.unaj.nightapp.model.Ciudad;

import java.util.List;

public interface CiudadService {

    List<Ciudad> getAll();
    Ciudad insert(Ciudad localidad);
    Ciudad getById(Long id) throws CiudadNotFoundException;
    Ciudad update(Ciudad localidad);
    void removeById(Long id);
    List<Ciudad> getAllFromLocalidadId(Long id);
}

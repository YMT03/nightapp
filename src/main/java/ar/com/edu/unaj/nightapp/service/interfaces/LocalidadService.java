package ar.com.edu.unaj.nightapp.service.interfaces;

import ar.com.edu.unaj.nightapp.exception.LocalidadNotFoundException;
import ar.com.edu.unaj.nightapp.model.Localidad;

import java.util.List;

public interface LocalidadService {

    List<Localidad> getAll();
    Localidad insert(Localidad localidad);
    Localidad getById(Long id) throws LocalidadNotFoundException;
    Localidad update(Localidad localidad);
    void removeById(Long id);
}

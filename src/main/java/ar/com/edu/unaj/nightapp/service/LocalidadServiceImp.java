package ar.com.edu.unaj.nightapp.service;

import ar.com.edu.unaj.nightapp.dao.LocalidadDAO;
import ar.com.edu.unaj.nightapp.exception.LocalidadNotFoundException;
import ar.com.edu.unaj.nightapp.model.Localidad;
import ar.com.edu.unaj.nightapp.service.interfaces.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadServiceImp implements LocalidadService {

    //TODO DOCUMENTACION
    @Autowired
    private LocalidadDAO localidadDAO;

    @Override
    public List<Localidad> getAll() {
        return (List<Localidad>) localidadDAO.findAll();
    }

    @Override
    public Localidad insert(Localidad localidad) {
        return localidadDAO.save(localidad);
    }

    @Override
    public Localidad getById(Long id) throws LocalidadNotFoundException {
        return localidadDAO.findById(id).orElseThrow(LocalidadNotFoundException::new);
    }

    @Override
    public Localidad update(Localidad localidad) throws LocalidadNotFoundException {
        getById(localidad.getId());
        return localidadDAO.save(localidad);
    }

    @Override
    public void removeById(Long id) throws LocalidadNotFoundException {
        localidadDAO.delete(localidadDAO.findById(id).orElseThrow(LocalidadNotFoundException::new));
    }
}

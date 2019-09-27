package ar.com.edu.unaj.nightapp.service;

import ar.com.edu.unaj.nightapp.dao.CiudadDAO;
import ar.com.edu.unaj.nightapp.dao.LocalidadDAO;
import ar.com.edu.unaj.nightapp.exception.CiudadNotFoundException;
import ar.com.edu.unaj.nightapp.exception.LocalidadNotFoundException;
import ar.com.edu.unaj.nightapp.model.Ciudad;
import ar.com.edu.unaj.nightapp.model.Localidad;
import ar.com.edu.unaj.nightapp.service.interfaces.CiudadService;
import ar.com.edu.unaj.nightapp.service.interfaces.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServiceImp implements CiudadService {

    //TODO DOCUMENTACION
    @Autowired
    private CiudadDAO ciudadDAO;

    @Override
    public List<Ciudad> getAll() {
        return (List<Ciudad>) ciudadDAO.findAll();
    }

    @Override
    public Ciudad insert(Ciudad ciudad) {
        return ciudadDAO.save(ciudad);
    }

    @Override
    public Ciudad getById(Long id) throws CiudadNotFoundException {
        return ciudadDAO.findById(id).orElseThrow(CiudadNotFoundException::new);
    }

    @Override
    public Ciudad update(Ciudad ciudad) throws CiudadNotFoundException {
        getById(ciudad.getId());
        return ciudadDAO.save(ciudad);
    }

    @Override
    public void removeById(Long id) throws LocalidadNotFoundException {
        ciudadDAO.delete(ciudadDAO.findById(id).orElseThrow(CiudadNotFoundException::new));
    }
}

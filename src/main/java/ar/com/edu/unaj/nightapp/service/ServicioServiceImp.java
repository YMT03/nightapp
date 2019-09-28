package ar.com.edu.unaj.nightapp.service;

import ar.com.edu.unaj.nightapp.dao.CategoriaDAO;
import ar.com.edu.unaj.nightapp.dao.ServicioDAO;
import ar.com.edu.unaj.nightapp.exception.CategoriaNotFoundException;
import ar.com.edu.unaj.nightapp.exception.ServicioNotFoundException;
import ar.com.edu.unaj.nightapp.model.Categoria;
import ar.com.edu.unaj.nightapp.model.Servicio;
import ar.com.edu.unaj.nightapp.service.interfaces.CategoriaService;
import ar.com.edu.unaj.nightapp.service.interfaces.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la logica respecto a Servicio
 */
@Service
public class ServicioServiceImp implements ServicioService {

    @Autowired
    private ServicioDAO servicioDAO;

    /**
     * @return Todos las servicios. s/paginacion. No se creeria necesario.
     */
    @Override
    public List<Servicio> getAll() {
        return (List<Servicio>) servicioDAO.findAll();
    }

    /**
     * @param servicio
     * @return Servicio creado
     */
    @Override
    public Servicio insert(Servicio servicio) {
        return servicioDAO.save(servicio);
    }

    /**
     * @param id del Servicio
     * @return Servicio
     * @throws ServicioNotFoundException Si no existe
     */
    @Override
    public Servicio getById(Long id) throws ServicioNotFoundException {
        return servicioDAO.findById(id).orElseThrow(ServicioNotFoundException::new);
    }

    /**
     * @param servicio a updatear
     * @return Servicio updateada
     * @throws ServicioNotFoundException Si no existia anteriormente p/ evitar insert en update.
     */
    @Override
    public Servicio update(Servicio servicio) throws ServicioNotFoundException{
        getById(servicio.getId()); //Throw Exception si no existia. Es update no insert.
        return servicioDAO.save(servicio);
    }

    /**
     * @param id Servicio a eliminar
     * @throws ServicioNotFoundException si no exister
     */
    @Override
    public void removeById(Long id) throws ServicioNotFoundException{
        servicioDAO.delete(getById(id));
    }
}

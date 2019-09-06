package ar.com.edu.unaj.nightapp.service;

import ar.com.edu.unaj.nightapp.dao.EstablecimientoDAO;
import ar.com.edu.unaj.nightapp.endpoint.dto.EstablecimientoDTO;
import ar.com.edu.unaj.nightapp.model.Establecimiento;
import ar.com.edu.unaj.nightapp.service.interfaces.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la logica respecto a Establecimiento
 */
@Service
public class EstablecimientoServiceImp implements EstablecimientoService {

    @Autowired
    private EstablecimientoDAO establecimientoDAO;

    /**
     * @return Lista completa de Establecimientos en la DB
     */
    @Override
    public List<Establecimiento> getAll() {
        return establecimientoDAO.findAll();
    }

    /**
     * Elimina el Establecimiento con el id pasado como parametro.
     * @param id id del Establecimiento a eliminar
     * @throws Exception En caso de no existir un Establecimiento de id {id}. TODO Pasar Exception a Exception particular para manejarla correctamente
     */
    @Override
    public void removeById(Long id) throws Exception {
        establecimientoDAO.delete(establecimientoDAO.findById(id).orElseThrow(Exception::new));
    }

    /**
     * @param id id del Establecimiento a obtener
     * @return Establecimiento en cuestion
     * @throws Exception En caso de no existir un Establecimiento de id {id}. TODO Pasar Exception a Exception particular para manejarla correctamente
     */
    @Override
    public Establecimiento getById(Long id) throws Exception {
        return establecimientoDAO.findById(id).orElseThrow(Exception::new);
    }

    /**
     * Inserta el Establecimiento recibido como param
     * @param establecimiento
     * @return El establecimiento insertado
     */
    @Override
    public Establecimiento insert(Establecimiento establecimiento) {
        return establecimientoDAO.save(establecimiento);
    }

    /**
     * @param establecimiento
     * @return Establecimiento actualizado
     * @throws Exception Tira excepcion si no existia un Establecimiento con ese Id. Se fuerza la Excepcion para evitar un INSERT. En tal caso la URL de peticion es otra.
     */
    @Override
    public Establecimiento update(Establecimiento establecimiento) throws Exception {
        establecimientoDAO.findById(establecimiento.getId()).orElseThrow(Exception::new);
        return establecimientoDAO.save(establecimiento);
    }
}

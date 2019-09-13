package ar.com.edu.unaj.nightapp.service;

import ar.com.edu.unaj.nightapp.dao.ComentarioDAO;
import ar.com.edu.unaj.nightapp.exception.ComentarioNotFoundException;
import ar.com.edu.unaj.nightapp.model.Comentario;
import ar.com.edu.unaj.nightapp.service.interfaces.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la logica respecto a Comentario
 */
@Service
public class ComentarioServiceImp implements ComentarioService {

    @Autowired
    private ComentarioDAO comentarioDAO;

    /**
     * Obtiene todos los comentarios que tiene un establecimiento, paginados.
     * @param establecimientoId Establecimiento en cuestion
     * @param offset Desplazamiento de la paginacion
     * @param size Cantidad de Comentarios a devolver
     * @return Todos los comentarios que tiene un Establecimiento particular.
     */
    @Override
    public List<Comentario> getAll(Long establecimientoId, Integer offset, Integer size) {
        Pageable pageable = PageRequest.of(offset, size);
        return comentarioDAO.getAllByEstablecimientoId(establecimientoId, pageable);
    }

    /**
     * @param establecimientoId Id del Establecimiento al cual pertenece. No seria necesario pero para evitar incongruencia en las peticiones url.
     * @param comentarioId Id del Comentario a Eliminar.
     * @throws ComentarioNotFoundException Si no existe o si hay incongruencia en la url.
     */
    @Override
    public void removeById(Long establecimientoId, Long comentarioId) throws ComentarioNotFoundException {
        comentarioDAO.delete(getById(establecimientoId,comentarioId));
    }

    @Override
    public Comentario insert(Comentario comentario) {
        return comentarioDAO.save(comentario);
    }

    @Override
    public Comentario update(Comentario comentario) throws ComentarioNotFoundException {
        return null;//TODO
    }

    /**
     * @param establecimientoId Id del Establecimiento al cual pertenece. No seria necesario pero para evitar incongruencia en las peticiones url.
     * @param comentarioId Id del Comentario a Eliminar.
     * @return Comentario
     * @throws ComentarioNotFoundException Si no existe o si esta mal referenciado respecto al Establecimiento.
     */
    @Override
    public Comentario getById(Long establecimientoId, Long comentarioId) throws ComentarioNotFoundException {
        Comentario comentario = comentarioDAO.getById(establecimientoId, comentarioId);
        if(comentario==null) throw new ComentarioNotFoundException();
        return comentario;
    }
}

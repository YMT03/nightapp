package ar.com.edu.unaj.nightapp.service.interfaces;

import ar.com.edu.unaj.nightapp.exception.ComentarioNotFoundException;
import ar.com.edu.unaj.nightapp.model.Comentario;

import java.util.List;

public interface ComentarioService {

    List<Comentario> getAll(Long establecimientoId, Integer offset, Integer size);
    void removeById(Long establecimientoId, Long comentarioId) throws ComentarioNotFoundException;
    Comentario insert(Comentario comentario);
    Comentario update(Comentario comentario) throws ComentarioNotFoundException;
    Comentario getById(Long establecimientoId, Long comentarioId) throws ComentarioNotFoundException;
}

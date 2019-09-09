package ar.com.edu.unaj.nightapp.dao;

import ar.com.edu.unaj.nightapp.model.Comentario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioDAO extends PagingAndSortingRepository<Comentario, Long> {

    @Query(value = "SELECT * FROM Comentarios c WHERE c.establecimiento_id=?1",nativeQuery = true)
    List<Comentario> getAllByEstablecimientoId(Long establecimientoId, Pageable pageable);
}

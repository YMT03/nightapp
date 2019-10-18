package ar.com.edu.unaj.nightapp.dao;

import ar.com.edu.unaj.nightapp.endpoint.dto.FiltroDTO;
import ar.com.edu.unaj.nightapp.model.Categoria;
import ar.com.edu.unaj.nightapp.model.Establecimiento;
import ar.com.edu.unaj.nightapp.model.Orden;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstablecimientoDAO  extends PagingAndSortingRepository<Establecimiento, Long> {

    List<Establecimiento> findByNombreContainingAndActivoTrueOrderByNombre(String name, Pageable pageable);

    @Query("SELECT DISTINCT e FROM ar.com.edu.unaj.nightapp.model.Establecimiento e " +
            "INNER JOIN e.categorias c " +
            "INNER JOIN e.servicios s " +
            "INNER JOIN e.menus m " +
            "WHERE c.nombre IN (?1) " +
            "AND s.nombre IN (?2) " +
            "AND m.nombre IN (?3) " +
            "AND ACTIVO=1")

    List<Establecimiento> getPaginatedAndFiltered(List<String> categorias, List<String> servicios, List<String> menus, Pageable pageable);

}

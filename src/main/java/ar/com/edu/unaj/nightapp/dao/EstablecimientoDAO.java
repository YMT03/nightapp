package ar.com.edu.unaj.nightapp.dao;

import ar.com.edu.unaj.nightapp.model.Establecimiento;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstablecimientoDAO  extends PagingAndSortingRepository<Establecimiento, Long> {
    List<Establecimiento> findByNombreContaining(String name, Pageable pageable);
}

package ar.com.edu.unaj.nightapp.dao;

import ar.com.edu.unaj.nightapp.model.Establecimiento;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablecimientoDAO  extends PagingAndSortingRepository<Establecimiento, Long> {
}

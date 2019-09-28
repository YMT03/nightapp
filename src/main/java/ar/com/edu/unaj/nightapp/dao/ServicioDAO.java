package ar.com.edu.unaj.nightapp.dao;

import ar.com.edu.unaj.nightapp.model.Servicio;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioDAO extends PagingAndSortingRepository<Servicio, Long> {

}

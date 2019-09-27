package ar.com.edu.unaj.nightapp.dao;

import ar.com.edu.unaj.nightapp.model.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadDAO extends PagingAndSortingRepository<Localidad, Long> {

}

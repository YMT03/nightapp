package ar.com.edu.unaj.nightapp.dao;

import ar.com.edu.unaj.nightapp.model.Ciudad;
import ar.com.edu.unaj.nightapp.model.Localidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadDAO extends PagingAndSortingRepository<Ciudad, Long> {

    @Query(value = "SELECT * FROM CIUDADES c WHERE c.LOCALIDAD_ID =?1",nativeQuery = true)
    List<Ciudad> getAllFromLocalidadId(Long id);

}

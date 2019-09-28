package ar.com.edu.unaj.nightapp.dao;

import ar.com.edu.unaj.nightapp.model.Categoria;
import ar.com.edu.unaj.nightapp.model.Menu;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDAO extends PagingAndSortingRepository<Menu, Long> {

}

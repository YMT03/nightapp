package ar.com.edu.unaj.nightapp.dao;

import ar.com.edu.unaj.nightapp.model.Categoria;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaDAO extends PagingAndSortingRepository<Categoria, Long> {

}

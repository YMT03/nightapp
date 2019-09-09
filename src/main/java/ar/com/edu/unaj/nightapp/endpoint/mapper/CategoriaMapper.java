package ar.com.edu.unaj.nightapp.endpoint.mapper;

import ar.com.edu.unaj.nightapp.endpoint.dto.CategoriaDTO;
import ar.com.edu.unaj.nightapp.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper implements Mapper<Categoria, CategoriaDTO> {

    @Override
    public CategoriaDTO mapToDTO(Categoria bo) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(bo.getId());
        categoriaDTO.setNombre(bo.getNombre());
        return categoriaDTO;
    }

    @Override
    public Categoria mapToBO(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setId(dto.getId());
        categoria.setNombre(dto.getNombre());
        return categoria;
    }
}

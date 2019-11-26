package ar.com.edu.unaj.nightapp.endpoint.mapper;

import ar.com.edu.unaj.nightapp.endpoint.dto.ComentarioDTO;
import ar.com.edu.unaj.nightapp.model.Comentario;
import org.springframework.stereotype.Component;

@Component
public class ComentarioMapper implements Mapper<Comentario, ComentarioDTO> {

    @Override
    public ComentarioDTO mapToDTO(Comentario bo) {
        ComentarioDTO comentarioDTO = new ComentarioDTO();
        comentarioDTO.setDescripcion(bo.getDescripcion());
        comentarioDTO.setId(bo.getId());
        comentarioDTO.setTitulo(bo.getTitulo());
        comentarioDTO.setNombreUsuario(bo.getUsuario().getNombre());

        return comentarioDTO;
    }

    @Override
    public Comentario mapToBO(ComentarioDTO dto) {
        Comentario comentario = new Comentario();
        comentario.setDescripcion(dto.getDescripcion());
        comentario.setTitulo(dto.getTitulo());
        comentario.setId(dto.getId());
        return comentario;
    }
}

package ar.com.edu.unaj.nightapp.endpoint.mapper;

import ar.com.edu.unaj.nightapp.endpoint.dto.UsuarioDTO;
import ar.com.edu.unaj.nightapp.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper implements Mapper<Usuario, UsuarioDTO> {
    @Override
    public UsuarioDTO mapToDTO(Usuario bo) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(bo.getId());
        usuarioDTO.setPassword(bo.getPassword());
        usuarioDTO.setUserName(bo.getUserName());
        usuarioDTO.setRol(bo.getRol());
        usuarioDTO.setNombre(bo.getNombre());
        usuarioDTO.setApellido(bo.getApellido());
        usuarioDTO.setMail(bo.getMail());
        usuarioDTO.setSecuredMail(bo.getSecuredMail());
        return usuarioDTO;
    }

    @Override
    public Usuario mapToBO(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setPassword(dto.getPassword());
        usuario.setUserName(dto.getUserName());
        usuario.setRol(dto.getRol());
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setMail(dto.getMail());
        usuario.setSecuredMail(dto.getSecuredMail());
        return usuario;
    }
}

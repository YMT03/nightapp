package ar.com.edu.unaj.nightapp.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * ComentarioDTO. Clase utilizada para transferencia de datos. Se mappea con @Comentario
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioDTO {

    @JsonProperty("Id")
    private Long id;

    @JsonProperty("Titulo")
    @Size(max = 70)
    @NotNull
    private String titulo;

    @JsonProperty("Descripcion")
    @Size(max = 2000)
    @NotNull
    private String descripcion;

    @JsonProperty("NombreUsuario")
    private String nombreUsuario;


}

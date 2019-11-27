package ar.com.edu.unaj.nightapp.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private String titulo;

    @JsonProperty("Comentario")
    @Size(max = 2000)
    @NotBlank
    private String descripcion;

    @JsonProperty("NombreUsuario")
    private String nombreUsuario;

    @JsonProperty("Rating")
    @NotNull
    private Integer rating;


}

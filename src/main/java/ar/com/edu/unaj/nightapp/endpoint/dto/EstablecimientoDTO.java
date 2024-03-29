package ar.com.edu.unaj.nightapp.endpoint.dto;

import ar.com.edu.unaj.nightapp.model.Comentario;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * EstablecimientoDTO. Clase utilizada para transferencia de datos. Se mappea con @Establecimiento
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstablecimientoDTO {

    @JsonProperty("Id")
    private Long id;

    @JsonProperty("Nombre")
    @NotBlank
    @Size(max = 150)
    private String nombre;

    @JsonProperty("Descripcion")
    @Size(max = 2000)
    private String descripcion;

    @JsonProperty("Categorias")
    private List<CategoriaDTO> categorias = new ArrayList<>();

    @JsonProperty("Comentarios")
    private List<ComentarioDTO> comentarioDTOS = new ArrayList<>();

    @JsonProperty("Servicios")
    private List<ServicioDTO> servicioDTOS = new ArrayList<>();

    @JsonProperty("Rating")
    private Integer rating;

    @JsonProperty("Activo")
    private Boolean activo;

    @JsonProperty("Direccion")
    private String direccion;

    @JsonProperty("Ciudad")
    private String ciudad;


}

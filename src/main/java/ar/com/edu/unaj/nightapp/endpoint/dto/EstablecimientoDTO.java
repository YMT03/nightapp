package ar.com.edu.unaj.nightapp.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

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

    @JsonProperty("Ubicacion")
    @NotNull
    private UbicacionDTO ubicacionDTO;


}

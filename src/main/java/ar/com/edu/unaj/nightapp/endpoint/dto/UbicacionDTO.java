package ar.com.edu.unaj.nightapp.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * UbicacionDTO. Clase utilizada para transferencia de datos. Se mappea con @Ubicacion
 */

@Data
public class UbicacionDTO {

    @JsonProperty("Id")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @JsonProperty("Direccion")
    private String direccion;

    @Size(max = 50)
    @NotNull
    @JsonProperty("Longitud")
    private Double longitud;

    @Size(max = 50)
    @NotNull
    @JsonProperty("Latitud")
    private Double latitud;


}

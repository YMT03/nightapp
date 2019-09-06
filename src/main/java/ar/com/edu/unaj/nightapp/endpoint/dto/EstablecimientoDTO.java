package ar.com.edu.unaj.nightapp.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String nombre;

}

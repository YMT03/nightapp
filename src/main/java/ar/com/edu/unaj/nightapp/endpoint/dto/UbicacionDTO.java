package ar.com.edu.unaj.nightapp.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UbicacionDTO {

    @JsonProperty("Id")
    private Long id;

    @NotBlank
    @JsonProperty("Direccion")
    private String direccion;

    @Size(max = 50)
    @JsonProperty("Longitud")
    private Double longitud;

    @Size(max = 50)
    @JsonProperty("Latitud")
    private Double latitud;


}

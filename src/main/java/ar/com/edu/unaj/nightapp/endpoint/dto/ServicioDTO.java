package ar.com.edu.unaj.nightapp.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ServicioDTO {

    @JsonProperty("Id")
    private Long id;

    @JsonProperty("Nombre")
    @NotBlank
    private String nombre;
}

package ar.com.edu.unaj.nightapp.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiudadDTO {

    @JsonProperty("Id")
    private Long id;

    @JsonProperty("Nombre")
    @NotBlank
    @Size(max = 50)
    private String nombre;

    @JsonProperty("Localidad")
    private LocalidadDTO localidadDTO;
}

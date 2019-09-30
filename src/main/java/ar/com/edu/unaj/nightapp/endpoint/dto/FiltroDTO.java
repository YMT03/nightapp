package ar.com.edu.unaj.nightapp.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class FiltroDTO {

    @JsonProperty("Categorias")
    @NotEmpty
    private List<String> categorias;

    @NotEmpty
    @JsonProperty("Servicios")
    private List<String> servicios;

    @NotEmpty
    @JsonProperty("Menu")
    private List<String> menus;

    @JsonProperty("Ubicacion")
    private List<CiudadDTO> ciudadDTOS;

}

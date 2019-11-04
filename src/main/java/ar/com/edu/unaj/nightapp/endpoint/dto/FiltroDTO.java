package ar.com.edu.unaj.nightapp.endpoint.dto;

import ar.com.edu.unaj.nightapp.model.Orden;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @JsonProperty("Menus")
    private List<String> menus;

    @JsonProperty("Ubicacion")
    private List<CiudadDTO> ciudadDTOS;

    @JsonProperty("Orden")
    @NotNull
    private Orden orden;

    @JsonProperty("Nombre")
    private String nombre;

}

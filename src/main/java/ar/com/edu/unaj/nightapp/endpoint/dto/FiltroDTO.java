package ar.com.edu.unaj.nightapp.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FiltroDTO {

    @JsonProperty("Tipo")
    private List<CategoriaDTO> categoriaDTOS;

}

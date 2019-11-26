package ar.com.edu.unaj.nightapp.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterDTO {

    @JsonProperty("Nombre")
    @NotBlank
    private String nombre;

    @JsonProperty("Apellido")
    @NotBlank
    private String apellido;

    @JsonProperty("Mail")
    @NotBlank
    private String mail;

    @JsonProperty("UserName")
    @NotBlank
    private String userName;

    @JsonProperty("Password")
    private String password;

}

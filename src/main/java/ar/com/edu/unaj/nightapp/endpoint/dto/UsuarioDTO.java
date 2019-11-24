package ar.com.edu.unaj.nightapp.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UsuarioDTO {

    @JsonProperty("Id")
    private Long id;

    @JsonProperty("Nombre")
    @NotBlank
    private String nombre;

    @JsonProperty("Apellido")
    @NotBlank
    private String apellido;

    @JsonProperty("Mail")
    @NotBlank
    private String mail;

    @JsonProperty("SecuredMail")
    private Boolean securedMail;

    @JsonProperty("UserName")
    @NotBlank
    private String userName;

    @JsonIgnore
    private String password;

    @JsonProperty("Rol")
    @NotBlank
    private String rol;
}

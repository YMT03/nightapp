package ar.com.edu.unaj.nightapp.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginDTO {

    @JsonProperty("UserName")
    private String userName;

    @JsonProperty("Password")
    private String password;
}

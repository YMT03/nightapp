package ar.com.edu.unaj.nightapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "USUARIOS")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ROL")
    private String rol;

    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name ="APELLIDO")
    private String apellido;
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "MAIL_CONFIRMADO")
    private Boolean securedMail = false;
    @Column(name = "ACTIVO")
    private Boolean active = true;

}

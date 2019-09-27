package ar.com.edu.unaj.nightapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "CIUDADES")
@Data
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "LOCALIDAD_ID")
    private Localidad localidad;
}

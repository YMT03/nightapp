package ar.com.edu.unaj.nightapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "CIUDADES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE", length = 50)
    private String nombre;

    @OneToOne
    @JoinColumn(name = "LOCALIDAD_ID")
    private Localidad localidad;
}

package ar.com.edu.unaj.nightapp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Ubicacion (BO).
 */
@Entity(name = "UBICACIONES")
@Data
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=100,nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "CIUDAD_ID")
    private Ciudad ciudad;

    @Column(length=50,nullable = false)
    private Double longitud;

    @Column(length=50,nullable = false)
    private Double latitud;
}

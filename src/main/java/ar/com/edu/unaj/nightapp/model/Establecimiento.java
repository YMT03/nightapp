package ar.com.edu.unaj.nightapp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Establecimiento (BO).
 */
@Entity(name = "establecimiento")
@Data
public class Establecimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false,length=150)
    private String nombre;
    @Column(length=2000)
    private String descripcion;
    @OneToOne(cascade = {CascadeType.ALL})
    private Ubicacion ubicacion;

}

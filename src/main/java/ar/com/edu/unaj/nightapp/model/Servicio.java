package ar.com.edu.unaj.nightapp.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Servicio (BO).
 */
@Entity(name = "SERVICIOS")
@Data
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "servicios")
    private List<Establecimiento> establecimientos;

}

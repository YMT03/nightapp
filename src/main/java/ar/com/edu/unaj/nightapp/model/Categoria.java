package ar.com.edu.unaj.nightapp.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Categoria (BO).
 */
@Entity(name = "CATEGORIAS")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categorias")
    private List<Establecimiento> establecimientos;

}

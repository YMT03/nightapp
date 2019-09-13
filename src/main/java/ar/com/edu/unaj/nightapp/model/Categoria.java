package ar.com.edu.unaj.nightapp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Categoria (BO).
 */
@Entity(name = "categorias")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

}

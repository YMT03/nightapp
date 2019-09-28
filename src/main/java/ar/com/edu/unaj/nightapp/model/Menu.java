package ar.com.edu.unaj.nightapp.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Menu (BO).
 */
@Entity(name = "MENUS")
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "menus")
    private List<Establecimiento> establecimientos;

}

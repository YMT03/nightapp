package ar.com.edu.unaj.nightapp.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Establecimiento (BO).
 */
@Entity(name = "ESTABLECIMIENTOS")
@Data
public class Establecimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Boolean activo;
    @Column(nullable=false,length=150)
    private String nombre;
    @Column(length=2000)
    private String descripcion;
    @Column(length = 1)
    private Integer rating;
    @OneToOne(cascade = {CascadeType.ALL})
    private Ubicacion ubicacion;
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "establecimiento")
    private List<Comentario> comentarios;
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="ESTABLECIMIENTOS_CATEGORIAS", joinColumns = @JoinColumn(name = "ESTABLECIMIENTO_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORIA_ID"))
    private List<Categoria> categorias;
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="ESTABLECIMIENTOS_SERVICIOS", joinColumns = @JoinColumn(name = "ESTABLECIMIENTO_ID"), inverseJoinColumns = @JoinColumn(name = "SERVICIO_ID"))
    private List<Servicio> servicios;
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="ESTABLECIMIENTOS_MENUS", joinColumns = @JoinColumn(name = "ESTABLECIMIENTO_ID"), inverseJoinColumns = @JoinColumn(name = "MENU_ID"))
    private List<Menu> menus;


}

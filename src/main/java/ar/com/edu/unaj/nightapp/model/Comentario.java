package ar.com.edu.unaj.nightapp.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;

/**
 * Comentario (BO).
 */
@Entity(name = "COMENTARIOS")
@Data
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 800)
    private String descripcion;

    @Column(nullable = true, length = 30)
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "ESTABLECIMIENTO_ID")
    private Establecimiento establecimiento;

    @Column(name="ESTABLECIMIENTO_ID",insertable = false, updatable = false)
    private Long establecimientoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;

    @Column(name = "CALIFICACION")
    @Max(5)
    private Integer rating;

}

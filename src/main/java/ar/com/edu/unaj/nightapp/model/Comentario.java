package ar.com.edu.unaj.nightapp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Ubicacion (BO).
 */

@Entity(name = "comentarios")
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
    @JoinColumn(name = "establecimiento_id")
    private Establecimiento establecimiento;

    @Column(name="establecimiento_id",insertable = false, updatable = false)
    private Long establecimientoId;

}

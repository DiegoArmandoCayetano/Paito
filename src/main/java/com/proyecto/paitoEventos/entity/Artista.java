package com.proyecto.paitoEventos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name="artistas")
@Getter
@Setter

public class Artista {

    @Id
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre_artistico", nullable=false, length = 150)
    private String nombreArtistico;

    @Column(columnDefinition="TEXT")
    private String descripcion;

    @Column(nullable=false, length=100)
    private String ciudad;

    @Column(nullable=false, length=550)
    private String experiencia;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_artista", nullable=false)
    private TipoArtista tipoArtista;

    @Column(nullable = false)
    private Boolean verificado;

    @Column(name="calificacion_promedio", precision=3, scale=2)
    private BigDecimal calificacionPromedio=BigDecimal.ZERO;

    @OneToOne
    @MapsId
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
}

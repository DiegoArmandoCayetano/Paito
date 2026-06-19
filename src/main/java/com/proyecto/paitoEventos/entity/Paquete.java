package com.proyecto.paitoEventos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "paquetes")
@Getter
@Setter
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paquete")
    private Integer idPaquete;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private BigDecimal precio;

    @Column(name = "duracion_hora", nullable = false, precision = 3, scale = 1)
    private BigDecimal duracionHora;

    @Column(name = "incluye_sonido", nullable = false)
    private Boolean incluyeSonido = false;

    @Column(name = "cantidad_max_publico")
    private Short cantidadMaxPublico;

    @Column(nullable = false)
    private Boolean activo = true;

    // Relación: Muchos paquetes pertenecen a un solo Artista
    @ManyToOne
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;
}
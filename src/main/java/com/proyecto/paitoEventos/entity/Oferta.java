package com.proyecto.paitoEventos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "ofertas")
@Getter
@Setter

public class Oferta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_oferta")
    private Integer idOferta;

    // Relación: Muchas ofertas corresponden a una Solicitud
    @ManyToOne
    @MapsId
    @JoinColumn(name="id_solicitud", nullable=false)
    private Solicitud solicitud;

    // Relación: Muchas ofertas son hechas por un Artista
    @ManyToOne
    @MapsId
    @JoinColumn(name="id_artista")
    private Artista artista;

    @Column(nullable=false, columnDefinition="TEXT")
    private String mensaje;

    @Column(name="fecha_oferta", nullable=false)
    private LocalDate fechaOferta;

    @Enumerated(EnumType.STRING)
    @Column(name="estado_oferta", nullable=false)
    private EstadoOferta estadoOferta;
}

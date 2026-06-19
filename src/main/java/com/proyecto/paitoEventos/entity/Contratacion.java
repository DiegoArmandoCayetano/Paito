package com.proyecto.paitoEventos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name="contrataciones")
@Getter
@Setter

public class Contratacion {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_contratacion")
    private Integer idContratacion;

    @OneToOne
    @MapsId
    @JoinColumn(name="id_solicitud", unique=true)
    private Solicitud solicitud;

    @ManyToOne
    @MapsId
    @JoinColumn(name="id_cliente", nullable=false)
    private Cliente cliente;

    @ManyToOne@MapsId
    @JoinColumn(name="id_artista", nullable=false)
    private Artista artista;

    @Column(name="monto_final", nullable=false)
    private Integer montoFinal;

    @Column(name="fecha_contratacion", nullable=false)
    private LocalDate fechaContratacion;

    @Enumerated(EnumType.STRING)
    @Column(name="estado_contratacion", nullable=false)
    private EstadoContratacion estadoContratacion;
}

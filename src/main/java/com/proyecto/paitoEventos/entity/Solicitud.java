package com.proyecto.paitoEventos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.math.BigDecimal;

@Entity
@Table(name="solicitudes")
@Getter
@Setter

public class Solicitud {
    @Id
    @Column(name="id_solicitud")
    private Integer idSolicitud;

    //Muchas solicitudes pertenecen a un único Cliente
    @ManyToOne
    @MapsId
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @Column(nullable=false, length=150)
    private String titulo;

    @Column(nullable=false, columnDefinition="TEXT")
    private String descripcion;

    @Column(name="fecha_evento", nullable=false)
    private LocalDate fehcaEvento;

    @Column(name="hora_inicio", nullable=false)
    private LocalTime horaInicio;

    @Column(name="hora_fin", nullable=false)
    private LocalTime fechaFin;

    @Column(nullable=false, length=255)
    private String direccion;

    @Column(nullable=false, length=100)
    private String ciudad;

    @Column(nullable=false)
    private BigDecimal presupuesto;

    @Column(name="cantidad_asistentes",nullable=false)
    private Integer cantidadAsistentes;

    @Enumerated(EnumType.STRING)
    @Column(name="estado_solicitud", nullable = false)
    private EstadoSolicitud estadoSolicitud = EstadoSolicitud.PENDIENTE;

    @Column(name="fecha_creacion", nullable=false)
    private LocalDate fechaCreacion;
}

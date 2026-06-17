package com.proyecto.paitoEventos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name="administadores")
@Getter
@Setter

public class Administrador {
    @Id
    @Column(name="id_usuario")
    private Integer idUsuario;

    @Column(name="codigo_admin", nullable=false, length=50, unique=true)
    private String codigoAdmin;

    @Column(name="fecha_creacion", nullable=false)
    private LocalDate fechaCreacion;

    @OneToOne
    @MapsId
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
}

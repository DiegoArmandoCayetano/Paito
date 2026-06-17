package com.proyecto.paitoEventos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name= "clientes")
@Getter
@Setter

public class Cliente {
    
    @Id
    @Column(name = "id_usuario")
    private Integer id_usuario;

    @OneToOne
    @MapsId//Esto le dice al JPA que el id_usuario de la entidad Uusario como PK y FK al mismo tiempo
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(nullable=false, length=100)
    private String ciudad;

    @Column(nullable=false, length=100)
    private String direccion;

    @Column(name="fecha_creacion", nullable=false)
    private LocalDate fechaCreacion;    
}

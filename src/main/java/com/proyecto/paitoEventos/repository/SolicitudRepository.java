package com.proyecto.paitoEventos.repository;

import com.proyecto.paitoEventos.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer>{
    // Métodos automáticos para controlar el ciclo de vida de las solicitudes
}

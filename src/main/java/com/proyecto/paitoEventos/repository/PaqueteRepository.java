package com.proyecto.paitoEventos.repository;

import com.proyecto.paitoEventos.entity.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface PaqueteRepository extends JpaRepository<Paquete, Integer>{
    // Spring Boot implementará el CRUD de paquetes automáticamente aquí
    // Ya tengo métodos como findAll(), findById(), save(), etc.
}

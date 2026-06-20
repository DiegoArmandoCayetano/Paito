package com.proyecto.paitoEventos.repository;

import com.proyecto.paitoEventos.entity.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PaqueteRpository extends JpaRepository<Paquete, Integer>{
    // Ya tengo métodos como findAll(), findById(), save(), etc.
}

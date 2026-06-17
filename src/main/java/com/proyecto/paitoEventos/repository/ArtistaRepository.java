package com.proyecto.paitoEventos.repository;

import com.proyecto.paitoEventos.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ArtistaRepository extends JpaRepository<Artista, Integer>{
    
}

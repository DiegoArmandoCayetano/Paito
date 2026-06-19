package com.proyecto.paitoEventos.repository;
import com.proyecto.paitoEventos.entity.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {}
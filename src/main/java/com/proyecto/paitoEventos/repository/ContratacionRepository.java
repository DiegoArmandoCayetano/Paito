package com.proyecto.paitoEventos.repository;
import com.proyecto.paitoEventos.entity.Contratacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratacionRepository extends JpaRepository<Contratacion, Integer> {}
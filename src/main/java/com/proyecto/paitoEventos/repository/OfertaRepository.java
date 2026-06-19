package com.proyecto.paitoEventos.repository;
import com.proyecto.paitoEventos.entity.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {}
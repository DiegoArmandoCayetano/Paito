package com.proyecto.paitoEventos.repository;

import com.proyecto.paitoEventos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}

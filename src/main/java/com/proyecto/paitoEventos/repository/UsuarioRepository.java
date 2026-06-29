package com.proyecto.paitoEventos.repository;

import com.proyecto.paitoEventos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    // Spring ya sabe que este bloque maneja los datos de la tabla "usuario

    // Método personalizado para buscar por correo (esencial para el login futuro)
    Optional<Usuario> findByCorreo(String correo);
}

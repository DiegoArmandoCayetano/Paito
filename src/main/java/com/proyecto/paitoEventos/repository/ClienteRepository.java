package com.proyecto.paitoEventos.repository;

import com.proyecto.paitoEventos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository; //Importa la herramienta estrella de Spring que te regala todos los métodos de base de datos (guardar, buscar, eliminar, actualizar).
import org.springframework.stereotype.Repository; //Importa la anotación que identifica el rol de esta clase.
//"Oye Spring, escanea esta interfaz, adminístrala en tu contenedor de memoria y prepárala porque es la encargada de hablar con la base de datos MySQL".    

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}

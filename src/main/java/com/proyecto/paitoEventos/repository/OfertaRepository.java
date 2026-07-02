package com.proyecto.paitoEventos.repository;
import com.proyecto.paitoEventos.entity.Oferta;
import com.proyecto.paitoEventos.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {

    // Método nuevo para buscar por el ID de la solicitud vinculada

    //Busca y extrae de la base de datos MySQL un listado con todas las ofertas económicas
    //  que existan en el sistema cuyo evento o solicitud coincida exactamente 
    // con el número de ID que le indiques por parámetro.
    List<Oferta> findBySolicitudIdSolicitud(Integer idSolicitud);

    List<Oferta> findBySolicitud(Solicitud solicitud);

}
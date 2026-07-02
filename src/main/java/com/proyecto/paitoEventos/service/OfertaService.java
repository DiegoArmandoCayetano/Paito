package com.proyecto.paitoEventos.service;

import com.proyecto.paitoEventos.entity.Artista;
import com.proyecto.paitoEventos.entity.EstadoOferta;
import com.proyecto.paitoEventos.entity.EstadoSolicitud;
import com.proyecto.paitoEventos.entity.Oferta;
import com.proyecto.paitoEventos.entity.Solicitud;
import com.proyecto.paitoEventos.repository.ArtistaRepository;
import com.proyecto.paitoEventos.repository.OfertaRepository;
import com.proyecto.paitoEventos.repository.SolicitudRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service

public class OfertaService {
    
    @Autowired
    private OfertaRepository ofertaRepository;

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Transactional
    public Oferta crearOferta(Oferta oferta, Integer idSolicitud, Integer idArtista ){
        if(idSolicitud==null){
            throw new RuntimeException("No existe la solicitud");
        }
        if(oferta.getValorOferta()==null || oferta.getValorOferta().compareTo(BigDecimal.ZERO)<=0 ){
            throw new RuntimeException("El valor de la oferta debe ser mayor a cero");
        }

        if(!solicitudRepository.existsById(idSolicitud)){
            throw new RuntimeException("La solicitud no existe");
        }

        if(!artistaRepository.existsById(idArtista)){
            throw new RuntimeException("El artista especificado no existe.");
        }

        Solicitud solicitudExistente = solicitudRepository.findById(idSolicitud).get();

        // Recuperamos el artista real de su repositorio correspondiente
        Artista artistaExistente = artistaRepository.findById(idArtista).get();

        oferta.setSolicitud(solicitudExistente);
        oferta.setArtista(artistaExistente);
        oferta.setEstadoOferta(EstadoOferta.PENDIENTE);

        return ofertaRepository.save(oferta);
    }

    @Transactional
    public Oferta aceptarOferta(Integer idOferta){

        if(!ofertaRepository.existsById(idOferta)){
            throw new RuntimeException("La oferta no existe");
        }

         //Aprobar la oferta elegida
        Oferta ofertaElegida = ofertaRepository.findById(idOferta).get();
        

        if(ofertaElegida.getEstadoOferta() == EstadoOferta.ACEPTADA ||
           ofertaElegida.getEstadoOferta() == EstadoOferta.RECHAZADA){
            throw new RuntimeException("no se puede aceptar una oferta ya procesada");
        }

        //Cerrar la solicitud del evento:
        Solicitud solicitudVinculada = ofertaElegida.getSolicitud();
        
        if(solicitudVinculada.getEstadoSolicitud() ==  EstadoSolicitud.ACEPTADA ||
           solicitudVinculada.getEstadoSolicitud() ==  EstadoSolicitud.FINALIZADA){
            throw new RuntimeException("Este evento ya cerró contrato con otro artista");
        }      

        //CAMBIOS DE ESTADO (Aprobar oferta y cerrar solicitud)
        ofertaElegida.setEstadoOferta(EstadoOferta.ACEPTADA);
        solicitudVinculada.setEstadoSolicitud(EstadoSolicitud.ACEPTADA);

        // ==========================================
        // NUEVA LÓGICA: RECHAZAR LA COMPETENCIA
        // ==========================================

        //Traemos TODAS las ofertas asociadas a esta misma solicitud
        List<Oferta> todasLasOfertas = ofertaRepository.findBySolicitudIdSolicitud(solicitudVinculada.getIdSolicitud());

        // Recorremos la lista con un bucle para alterar a las perdedoras
        for(Oferta operacion : todasLasOfertas){
            if(!operacion.getIdOferta().equals(ofertaElegida.getIdOferta())){
                operacion.setEstadoOferta(EstadoOferta.RECHAZADA);
                
                // Guardamos el rechazo en MySQL
                ofertaRepository.save(operacion);

            }
        }

        solicitudRepository.save(solicitudVinculada);
        return ofertaRepository.save(ofertaElegida);
    }

}

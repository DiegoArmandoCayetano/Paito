package com.proyecto.paitoEventos.service;

import com.proyecto.paitoEventos.entity.Artista;
import com.proyecto.paitoEventos.entity.EstadoOferta;
import com.proyecto.paitoEventos.entity.Oferta;
import com.proyecto.paitoEventos.entity.Solicitud;
import com.proyecto.paitoEventos.repository.ArtistaRepository;
import com.proyecto.paitoEventos.repository.OfertaRepository;
import com.proyecto.paitoEventos.repository.SolicitudRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

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
}

package com.proyecto.paitoEventos.service;

import com.proyecto.paitoEventos.entity.Cliente;
import com.proyecto.paitoEventos.entity.EstadoSolicitud;
import com.proyecto.paitoEventos.entity.Solicitud;
import com.proyecto.paitoEventos.repository.ClienteRepository;
import com.proyecto.paitoEventos.repository.SolicitudRepository;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.stereotype.Service;


@Service

public class SolicitudService {
    @Autowired
    private SolicitudRepository solicitudRepository;


    @Autowired
    private ClienteRepository clienteRepository;


    // 1. El método ahora recibe los datos que necesitas (la solicitud a crear y el id del cliente)
    public Solicitud crearSolicitud(Solicitud solicitud, Integer idCliente){
        
        // 1. El método ahora recibe los datos que necesitas (la solicitud a crear y el id del cliente)
        if(!clienteRepository.existsById(idCliente)){
            throw new RuntimeException("El Cliente no existe");
        }

        else{
            // 1. Buscamos al cliente real. Si no existe, se lanza la excepción inmediatamente.

            Cliente clienteExistente = clienteRepository.findById(idCliente).get();
            // 2. ¡Aquí se hace la conexión! Le inyectamos el cliente completo a la solicitud
            solicitud.setCliente(clienteExistente);
            
            //3. Asignamos los valores automáticos que planeamos
            solicitud.setEstadoSolicitud(EstadoSolicitud.PENDIENTE);

            // (Aquí asigno la fecha de creación)
            
            solicitud.setFechaCreacion(LocalDate.now());

        

            // 4. Guardamos en la base de datos y retornamos
            return solicitudRepository.save(solicitud);
        }
    }
}

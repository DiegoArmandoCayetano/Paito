package com.proyecto.paitoEventos.controller;

import com.proyecto.paitoEventos.service.SolicitudService;
import com.proyecto.paitoEventos.entity.Solicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/solicitudes")
@CrossOrigin(origins="*")

public class SolicitudController {
    
    @Autowired
    private SolicitudService solicitudService;
    
    @PostMapping("/clientes/{idCliente}")

    public ResponseEntity<?> crearSolicitud(@RequestBody Solicitud solicitud,
        @PathVariable Integer idCliente) {
        
        try{
            Solicitud nuevaSolicitud = solicitudService.crearSolicitud(solicitud, idCliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSolicitud);
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}

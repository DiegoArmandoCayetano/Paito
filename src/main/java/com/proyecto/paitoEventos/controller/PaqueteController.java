package com.proyecto.paitoEventos.controller;

import com.proyecto.paitoEventos.entity.Paquete;
import com.proyecto.paitoEventos.service.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paquetes")
@CrossOrigin(origins="*")   

public class PaqueteController {
 @Autowired
 private PaqueteService paqueteService;

@GetMapping
    public List<Paquete> obtenerTodos(){
        return paqueteService.listarTodos();
    }

@PostMapping
    public Paquete crear(@RequestBody Paquete paquete){
        return paqueteService.guardar(paquete);
    }
@GetMapping("/{id}")
    public ResponseEntity<Paquete> obtenerPorId(@PathVariable Integer id){
        return paqueteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
    }

@DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        paqueteService.eliminarPaqueteService(id);
        return ResponseEntity.noContent().build();
    }
}
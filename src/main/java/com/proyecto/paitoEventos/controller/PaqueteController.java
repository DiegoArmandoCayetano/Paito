package com.proyecto.paitoEventos.controller;

import com.proyecto.paitoEventos.entity.Paquete;
import com.proyecto.paitoEventos.service.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
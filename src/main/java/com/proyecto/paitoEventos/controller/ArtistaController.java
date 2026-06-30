package com.proyecto.paitoEventos.controller;

import com.proyecto.paitoEventos.entity.Artista;
import com.proyecto.paitoEventos.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/artistas")
@CrossOrigin(origins="*")

public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;


    @GetMapping
    public List<Artista> obtenerTodos(){
        return artistaService.listarTodos();
    }

    @PostMapping("path")
    public ResponseEntity<Artista> crear(@RequestBody Artista artista) {
       
        Artista nuevoArtista = artistaService.registrarArtista(artista); 
        return new ResponseEntity<>(nuevoArtista, HttpStatus.CREATED);
    }
    
}

package com.proyecto.paitoEventos.controller;

import com.proyecto.paitoEventos.entity.Usuario;
import com.proyecto.paitoEventos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins="*")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> obtenerTodos(){
        return usuarioService.listarTodos();
    }

    @GetMapping("/id")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Integer id){
        return usuarioService.buscarPorId(id)
         .map(ResponseEntity::ok)
          .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario){
        Usuario nuevoUsuario = usuarioService.registrar(usuario);
        return new ResponseEntity<>(nuevoUsuario,HttpStatus.CREATED);
    }

}

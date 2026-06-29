package com.proyecto.paitoEventos.controller;

import com.proyecto.paitoEventos.entity.Cliente;
import com.proyecto.paitoEventos.service.ClienteService ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")

public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping
    public List<Cliente> obtenerTodos(){
        return clienteService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente){
        Cliente nuevoCliente = clienteService.registrarCliente(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

}

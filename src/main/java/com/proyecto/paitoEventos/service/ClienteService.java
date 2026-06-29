package com.proyecto.paitoEventos.service;

import com.proyecto.paitoEventos.entity.Cliente;
import com.proyecto.paitoEventos.entity.Usuario;
import com.proyecto.paitoEventos.repository.ClienteRepository;
import com.proyecto.paitoEventos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service

public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente registrarCliente(Cliente cliente){
        // 1. extraemos el usuario que viene dentro del objeto Cliente
        Usuario usuario = cliente.getUsuario();

        // 2. Guardamos primero el usuario base para que MySQL genere el id_usuario
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        // 3. Vinculamos el usuario ya guardado (con su ID) de vuelta al cliente
        cliente.setUsuario(usuarioGuardado);

        return clienteRepository.save(cliente);

    }
}

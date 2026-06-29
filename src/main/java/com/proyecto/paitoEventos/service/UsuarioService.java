package com.proyecto.paitoEventos.service;

import com.proyecto.paitoEventos.entity.Usuario;
import com.proyecto.paitoEventos.repository.UsuarioRepository;

import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service

public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id){
        return usuarioRepository.findById(id);
    }

    public Usuario registrar(Usuario usuario){
        //Añadir validaciones

        //1. Buscamos el correo y usamos .isEmpty() para saber si está libre
        if(usuarioRepository.findByCorreo(usuario.getCorreo()).isEmpty()){
            
            //si está vacío, significa que NADIE tiene ese correo. ¡es seguro guardarlo
            return usuarioRepository.save(usuario);
        }
        
        throw new RuntimeException("El correo ya está registrado");
        

    }

}

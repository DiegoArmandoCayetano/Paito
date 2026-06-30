package com.proyecto.paitoEventos.service;

import com.proyecto.paitoEventos.entity.Artista;
import com.proyecto.paitoEventos.entity.Usuario;
import com.proyecto.paitoEventos.repository.ArtistaRepository;
import com.proyecto.paitoEventos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ArtistaService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private ArtistaRepository artistaRepository;

    public List<Artista> listarTodos(){
        return artistaRepository.findAll();
    }

    @Transactional
    public Artista registrarArtista(Artista artista){

        //1. Extraemos el usuario que viene dentro del objeto artista 
        Usuario usuario = artista.getUsuario();

        //2. GUARDAMOS PRIMERO EL USUARIO EN LA BASE DE DATOS PARA QUE MYSQL GENERE EL id_usuario
        Usuario usuarioGuardado=usuarioRepository.save(usuario);

        //3. vinculamos el usuario ya guardado con su id de vuelta al artista
        artista.setUsuario(usuarioGuardado);

        return artistaRepository.save(artista);

    }

}

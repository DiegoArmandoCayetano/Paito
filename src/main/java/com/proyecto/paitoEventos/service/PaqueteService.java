package com.proyecto.paitoEventos.service;

import com.proyecto.paitoEventos.entity.Paquete;
import com.proyecto.paitoEventos.repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service

public class PaqueteService {
    @Autowired
    private PaqueteRepository paqueteRepository;

    public List<Paquete> listarTodos(){
        return paqueteRepository.findAll();
    }

    public Paquete guardar(Paquete paquete){
        return paqueteRepository.save(paquete);
    }

    public Optional<Paquete> buscarPorId(Integer id) {
    // Aquí adentro uso el repositorio y su método nativo findById
    return paqueteRepository.findById(id);
    }

    public void eliminarPaqueteService(Integer id){
        paqueteRepository.deleteById(id);
    }
}
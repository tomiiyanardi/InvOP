package com.example.demo.services;

import com.example.demo.entities.FamiliaProductos;
import com.example.demo.repositories.BaseRepository;
import com.example.demo.repositories.FamiliaProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliaProductosServiceImpl extends BaseServiceImpl<FamiliaProductos, Long> implements FamiliaProductosService{

    @Autowired
    private FamiliaProductosRepository familiaProductosRepository;

    public FamiliaProductosServiceImpl(BaseRepository<FamiliaProductos, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<FamiliaProductos> search(String filtro) throws Exception {

        try {
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            List<FamiliaProductos> familiaProductos = familiaProductosRepository.search(filtro);
            //List<Persona> personas = personaRepository.searchNativo(filtro);

            return familiaProductos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<FamiliaProductos> search(String filtro, Pageable pageable) throws Exception {

        try {
            //Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            Page<FamiliaProductos> familiaProductos = familiaProductosRepository.search(filtro, pageable);
            //Page<Persona> personas = personaRepository.searchNativo(filtro, pageable);

            return familiaProductos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

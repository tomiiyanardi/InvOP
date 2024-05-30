package com.example.demo.services;

import com.example.demo.entities.FamiliaProductos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FamiliaProductosService extends BaseService<FamiliaProductos,Long>{
    List<FamiliaProductos> search(String filtro) throws Exception;

    Page<FamiliaProductos> search(String filtro, Pageable pageable) throws Exception;
}

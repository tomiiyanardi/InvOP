package com.example.demo.repositories;

import com.example.demo.entities.FamiliaProductos;
import com.example.demo.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FamiliaProductosRepository extends BaseRepository<FamiliaProductos, Long> {


    //Anotacion Metodo de Query
    List<FamiliaProductos> findByNombreContainingOrCodeContaining(String nombre, String code);

    Page<FamiliaProductos> findByNombreContainingOrCodeContaining(String nombre, String code, Pageable pageable);

    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT f FROM FamiliaProductos f WHERE f.nombre LIKE %:filtro% OR f.code LIKE %:filtro%")
    List<FamiliaProductos> search(@Param("filtro") String filtro);

    @Query(value = "SELECT f FROM FamiliaProductos f WHERE f.nombre LIKE %:filtro% OR p.code LIKE %:filtro%")
    Page<FamiliaProductos> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM familiaproductos WHERE familiaproductos.nombre LIKE %:filtro% OR familiaproductos.code LIKE %:filtro%",
            nativeQuery = true
    )
    List<FamiliaProductos> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM familiaproductos WHERE familiaproductos.nombre LIKE %:filtro% OR familiaproductos.code LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<FamiliaProductos> searchNativo(@Param("filtro") String filtro, Pageable pageable);


}
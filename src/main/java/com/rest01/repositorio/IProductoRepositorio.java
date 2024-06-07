package com.rest01.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rest01.modelo.Producto;

public interface IProductoRepositorio extends JpaRepository<Producto, Integer> {
 
}

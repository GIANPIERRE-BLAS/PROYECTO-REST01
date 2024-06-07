package com.rest01.service;

import java.util.List;
import java.util.Optional;

import com.rest01.modelo.Producto;

public interface IProductoService {
    List<Producto> listarProducto();
    Producto guardarProducto(Producto producto);
    Optional<Producto> buscarProducto(int id);
    void eliminarProducto(int id);
}

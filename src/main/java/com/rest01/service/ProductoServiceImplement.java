package com.rest01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest01.modelo.Producto;
import com.rest01.repositorio.IProductoRepositorio;

@Service
public class ProductoServiceImplement implements IProductoService {

    @Autowired
    private IProductoRepositorio repositorio;

    @Override
    public List<Producto> listarProducto() {
        return repositorio.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return repositorio.save(producto);
    }

    @Override
    public Optional<Producto> buscarProducto(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminarProducto(int id) {
        repositorio.deleteById(id);
    }
}

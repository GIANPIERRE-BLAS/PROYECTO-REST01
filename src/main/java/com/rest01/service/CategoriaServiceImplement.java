package com.rest01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest01.modelo.Categoria;
import com.rest01.repositorio.ICategoriaRepositorio;

@Service
public class CategoriaServiceImplement implements ICategoriaService {

    @Autowired
    private ICategoriaRepositorio repositorio;

    @Override
    public List<Categoria> listarCategoria() {
        return repositorio.findAll();
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return repositorio.save(categoria);
    }

    @Override
    public Optional<Categoria> buscarCategoria(int codigo) {
        return repositorio.findById(codigo);
    }

    @Override
    public void eliminarCategoria(int codigo) {
        repositorio.deleteById(codigo);
    }
}

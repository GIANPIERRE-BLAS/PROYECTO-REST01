package com.rest01.service;

import java.util.List;
import java.util.Optional;

import com.rest01.modelo.Categoria;

public interface ICategoriaService {
    public List<Categoria> listarCategoria();
    public Categoria guardarCategoria(Categoria categoria);
    public Optional<Categoria> buscarCategoria(int codigo);
    public void eliminarCategoria(int codigo);
}

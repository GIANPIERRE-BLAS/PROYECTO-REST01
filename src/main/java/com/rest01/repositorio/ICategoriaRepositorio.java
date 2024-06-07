package com.rest01.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest01.modelo.Categoria;

public interface ICategoriaRepositorio extends JpaRepository<Categoria, Integer> {

}

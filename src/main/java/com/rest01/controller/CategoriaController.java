package com.rest01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rest01.modelo.Categoria;
import com.rest01.service.ICategoriaService;

@Controller
public class CategoriaController {

    @Autowired
    private ICategoriaService servicio;

    @GetMapping("/")
    public String Index() {
        return "index";
    }

    @GetMapping("/listarCategoria")
    public String listarCategoria(Model modelo) {
        modelo.addAttribute("categorias", servicio.listarCategoria());
        return "categorias";
    }

    @GetMapping("/nuevoCategoria")
    public String newCategoria(Model modelo) {
        modelo.addAttribute("categoria", new Categoria());
        return "formCategoria";
    }

    @PostMapping("/saveCategoria")
    public String saveCategoria(Categoria categoria) {
        servicio.guardarCategoria(categoria);
        return "redirect:/listarCategoria";
    }

    @GetMapping("/editar/{codigo}")
    public String editCategoria(@PathVariable int codigo, Model modelo) {
        servicio.buscarCategoria(codigo).ifPresent(categoria -> modelo.addAttribute("categoria", categoria));
        return "formCategoria";
    }

    @GetMapping("/eliminar/{codigo}")
    public String deleteCategoria(@PathVariable int codigo) {
        servicio.eliminarCategoria(codigo);
        return "redirect:/listarCategoria";
    }
}


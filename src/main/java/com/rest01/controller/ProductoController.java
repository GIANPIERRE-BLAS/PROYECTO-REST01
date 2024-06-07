package com.rest01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rest01.modelo.Producto;
import com.rest01.service.ICategoriaService;
import com.rest01.service.IProductoService;

@Controller
public class ProductoController {
    
    @Autowired
    private IProductoService productoService;
    
    @Autowired
    private ICategoriaService categoriaService;
    
    @GetMapping("/listarProducto")
    public String listarProducto(Model modelo) {
        modelo.addAttribute("productos", productoService.listarProducto());
        return "producto";
    }
    
    @GetMapping("/nuevoProducto")
    public String newProducto(Model modelo) {
        modelo.addAttribute("producto", new Producto());
        modelo.addAttribute("categorias", categoriaService.listarCategoria());
        return "formProductos";
    }
    
    @PostMapping("/saveProducto")
    public String saveProducto(Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/listarProducto";
    }

    @PostMapping("/crearProducto")
    public String crearProducto(Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/listarProducto";
    }
    
    @GetMapping("/editarProducto/{id}")
    public String editProductoById(@PathVariable int id, Model modelo) {
        Producto producto = productoService.buscarProducto(id).orElse(null);
        modelo.addAttribute("producto", producto);
        modelo.addAttribute("categorias", categoriaService.listarCategoria());
        modelo.addAttribute("isNewProduct", false); // Establece isNewProduct como false
        return "formProductos";
    }

    @PostMapping("/editarProducto/{id}")
    public String updateProducto(@PathVariable int id, Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/listarProducto";
    }
    
    @GetMapping("/eliminarProducto/{id}")
    public String deleteProducto(@PathVariable int id) {
        productoService.eliminarProducto(id);
        return "redirect:/listarProducto";
    }
}


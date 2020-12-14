package com.jackwesley.cursospringboot.resources;

import com.jackwesley.cursospringboot.domain.Categoria;
import com.jackwesley.cursospringboot.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){


        Categoria categoria = categoriaService.findById(id);

        return ResponseEntity.ok().body(categoria);
    }
}

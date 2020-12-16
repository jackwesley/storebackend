package com.jackwesley.cursospringboot.services;

import com.jackwesley.cursospringboot.domain.Categoria;
import com.jackwesley.cursospringboot.repositories.CategoriaRepository;
import com.jackwesley.cursospringboot.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id){

        Optional<Categoria> categoria = categoriaRepository.findById(id);

        return  categoria.orElseThrow(
                () -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id +", Tipo: " + Categoria.class.getName())
        );
    }
}

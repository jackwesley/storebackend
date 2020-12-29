package com.jackwesley.cursospringboot.services;

import com.jackwesley.cursospringboot.domain.Categoria;
import com.jackwesley.cursospringboot.domain.Pedido;
import com.jackwesley.cursospringboot.repositories.PedidoRepository;
import com.jackwesley.cursospringboot.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido findById(Integer id){

        Optional<Pedido> pedido = pedidoRepository.findById(id);

        return pedido.orElseThrow(
                () -> new ObjectNotFoundException(
                        "Objeto não encontrado! Id: " + id +", Tipo: " + Categoria.class.getName())
        );
    }
}

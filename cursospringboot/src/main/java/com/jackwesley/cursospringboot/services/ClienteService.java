package com.jackwesley.cursospringboot.services;

import com.jackwesley.cursospringboot.domain.Categoria;
import com.jackwesley.cursospringboot.domain.Cliente;
import com.jackwesley.cursospringboot.repositories.ClienteRepository;
import com.jackwesley.cursospringboot.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Integer id){

        Optional<Cliente> cliente = clienteRepository.findById(id);

        return cliente.orElseThrow(
                () -> new ObjectNotFoundException(
                        "Objeto não encontrado! Id: " + id +", Tipo: " + Categoria.class.getName())
        );
    }
}

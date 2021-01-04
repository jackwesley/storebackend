package com.jackwesley.cursospringboot.services;

import com.jackwesley.cursospringboot.domain.Categoria;
import com.jackwesley.cursospringboot.repositories.CategoriaRepository;
import com.jackwesley.cursospringboot.services.exceptions.DataIntegrityException;
import com.jackwesley.cursospringboot.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Categoria insert(Categoria categoria){
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria){
        findById(categoria.getId());
        return categoriaRepository.save(categoria);
    }

    public void delete(Integer id){
        findById(id);
        try{
            categoriaRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException exception){
            throw new DataIntegrityException("Não é possível excluir categoria associada a produtos");
        }

    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Page<Categoria> findPage(Integer page,
                                    Integer linesPerPage,
                                    String orderBy,
                                    String direction){

        PageRequest pageRequest = PageRequest.of(page,
                linesPerPage,
                Sort.Direction.valueOf(direction),
                orderBy);

        return categoriaRepository.findAll(pageRequest);

    }
}

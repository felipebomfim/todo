package com.exemplo.todo.service;

import com.exemplo.todo.entity.Tarefa;
import com.exemplo.todo.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<Tarefa> listar() {
        return repository.findAll();
    }

    public Tarefa salvar(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public Tarefa atualizar(Long id, Tarefa novaTarefa) {
        return repository.findById(id)
                .map(t -> {
                    t.setDescricao(novaTarefa.getDescricao());
                    t.setConcluida(novaTarefa.getConcluida());
                    return repository.save(t);
                }).orElseThrow();
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}

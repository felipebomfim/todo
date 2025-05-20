package com.exemplo.todo.controller;

import com.exemplo.todo.entity.Tarefa;
import com.exemplo.todo.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*") // liberando acesso para o frontend
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return service.listar();
    }

    @PostMapping
    public Tarefa salvar(@RequestBody Tarefa tarefa) {
        return service.salvar(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return service.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}

package com.projetos_kaillanny.task.master.service;

import com.projetos_kaillanny.task.master.model.StatusTarefa;
import com.projetos_kaillanny.task.master.model.Tarefa;
import com.projetos_kaillanny.task.master.repository.TarefaRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa salvar(Tarefa tarefa) {
        if (tarefa.getId() == null) {
            tarefa.setStatus(StatusTarefa.PENDENTE);
        }
        return tarefaRepository.save(tarefa);
    }
}

package com.projetos_kaillanny.task.master.controller;

import com.projetos_kaillanny.task.master.model.Tarefa;
import com.projetos_kaillanny.task.master.service.TarefaService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Data
@Controller
public class TarefaController {
    private final TarefaService tarefaService;

    @GetMapping("/tarefas")
    public String listarTarefas(Model model) {
        List<Tarefa> listaDoBanco = tarefaService.listarTarefas();

        model.addAttribute("tarefas", listaDoBanco);

        return "lista-tarefas";
    }

    @GetMapping("/tarefas/nova")
    public String criarTarefa(Model model) {
        Tarefa tarefa = new Tarefa();

        model.addAttribute("tarefa", tarefa);

        return "nova-tarefa";
    }

    @PostMapping("/tarefas/salvar")
    public String salvarTarefa(@ModelAttribute("tarefa") Tarefa tarefa, BindingResult result) {
        if(result.hasErrors()) {
            return "nova-tarefa";
        }

        tarefaService.salvar(tarefa);

        return "redirect:/tarefas";
    }
}

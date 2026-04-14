package com.samuel.chamados.controller;

import com.samuel.chamados.entity.Chamado;
import com.samuel.chamados.enums.Prioridade;
import com.samuel.chamados.enums.StatusChamado;
import com.samuel.chamados.service.ChamadoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Chamado criarChamado(@RequestBody Chamado chamado) {
        return chamadoService.criarChamado(chamado);
    }

    @GetMapping
    public List<Chamado> listarTodos() {
        return chamadoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Chamado buscarPorId(@PathVariable Long id) {
        return chamadoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Chamado atualizarChamado(@PathVariable Long id, @RequestBody Chamado chamado) {
        return chamadoService.atualizarChamado(id, chamado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarChamado(@PathVariable Long id) {
        chamadoService.deletarChamado(id);
    }

    @GetMapping("/status/{status}")
    public List<Chamado> buscarPorStatus(@PathVariable StatusChamado status) {
        return chamadoService.buscarPorStatus(status);
    }

    @GetMapping("/prioridade/{prioridade}")
    public List<Chamado> buscarPorPrioridade(@PathVariable Prioridade prioridade) {
        return chamadoService.buscarPorPrioridade(prioridade);
    }
}
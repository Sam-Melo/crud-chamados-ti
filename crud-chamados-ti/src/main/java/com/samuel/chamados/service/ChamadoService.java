package com.samuel.chamados.service;

import com.samuel.chamados.entity.Chamado;
import com.samuel.chamados.enums.Prioridade;
import com.samuel.chamados.enums.StatusChamado;
import com.samuel.chamados.repository.ChamadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;

    public ChamadoService(ChamadoRepository chamadoRepository) {
        this.chamadoRepository = chamadoRepository;
    }

    public Chamado criarChamado(Chamado chamado) {
        return chamadoRepository.save(chamado);
    }

    public List<Chamado> listarTodos() {
        return chamadoRepository.findAll();
    }

    public Chamado buscarPorId(Long id) {
        return chamadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado com id: " + id));
    }

    public Chamado atualizarChamado(Long id, Chamado chamadoAtualizado) {
        Chamado chamadoExistente = buscarPorId(id);

        chamadoExistente.setTitulo(chamadoAtualizado.getTitulo());
        chamadoExistente.setDescricao(chamadoAtualizado.getDescricao());
        chamadoExistente.setResponsavel(chamadoAtualizado.getResponsavel());
        chamadoExistente.setPrioridade(chamadoAtualizado.getPrioridade());
        chamadoExistente.setStatus(chamadoAtualizado.getStatus());

        return chamadoRepository.save(chamadoExistente);
    }

    public void deletarChamado(Long id) {
        Chamado chamado = buscarPorId(id);
        chamadoRepository.delete(chamado);
    }

    public List<Chamado> buscarPorStatus(StatusChamado status) {
        return chamadoRepository.findByStatus(status);
    }

    public List<Chamado> buscarPorPrioridade(Prioridade prioridade) {
        return chamadoRepository.findByPrioridade(prioridade);
    }
}
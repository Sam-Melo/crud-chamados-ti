package com.samuel.chamados.repository;

import com.samuel.chamados.entity.Chamado;
import com.samuel.chamados.enums.Prioridade;
import com.samuel.chamados.enums.StatusChamado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

    List<Chamado> findByStatus(StatusChamado status);

    List<Chamado> findByPrioridade(Prioridade prioridade);
}
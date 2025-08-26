package Agends.Agendamentos.dto;

import Agends.Agendamentos.Entity.Configuracao;
import Agends.Agendamentos.Entity.DiaSemana;

import java.time.LocalTime;

public record ConfiguracaoResponse(
  Long id,
  LocalTime horarioAbertura,
  LocalTime horarioFechamento,
  DiaSemana diaSemana

) {
  public ConfiguracaoResponse (Configuracao configuracao) {
    this(
      configuracao.getId(),
      configuracao.getHorarioAbertura(),
      configuracao.getHorarioFechamento(),
      configuracao.getDiaSemana()
    );
  }

}

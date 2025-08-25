package Agends.Agendamentos.dto;

import Agends.Agendamentos.Entity.DiaSemana;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record ConfigHorarioDiaFuncionamentoRequest(
  @NotNull
  LocalTime horarioAbertura,
  @NotNull
  LocalTime horarioFechamento,
  @NotNull
  DiaSemana diaSemana

) {
}

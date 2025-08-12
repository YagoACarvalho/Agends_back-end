package Agends.Agendamentos.dto;

import Agends.Agendamentos.Entity.Procedimento;

import java.time.LocalDateTime;

public record ProximoAgendamento(

  Long id,
  String nome,
  Procedimento procedimento,
  LocalDateTime dataHora

) {
}

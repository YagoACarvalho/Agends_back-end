package Agends.Agendamentos.dto;

import java.time.LocalDateTime;

public record ProximoAgendamento(

  Long id,
  String cliente,
  String servico,
  LocalDateTime dataHora

) {
}

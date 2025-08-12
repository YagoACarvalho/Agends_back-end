package Agends.Agendamentos.dto;

import java.util.List;
import java.math.BigDecimal;

public record DashboardResponse(

  long agendamentosHoje,
  long agendamentosMes,
  BigDecimal totalFaturadoMês,
  List<ProximoAgendamento> proximoAgendamentos

) {
}

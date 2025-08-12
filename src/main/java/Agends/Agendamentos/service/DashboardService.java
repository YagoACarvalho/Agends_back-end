package Agends.Agendamentos.service;


import Agends.Agendamentos.dto.DashboardResponse;
import Agends.Agendamentos.dto.ProximoAgendamento;
import Agends.Agendamentos.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
public class DashboardService {

  private final AgendamentoRepository agendamentoRepository;

  public DashboardService(AgendamentoRepository agendamentoRepository) {
    this.agendamentoRepository = agendamentoRepository;
  }

  public DashboardResponse mostrarDashboard() {
    long hoje = agendamentoRepository.countByDataHoraBetween(
      LocalDate.now().atStartOfDay(),
      LocalDate.now().plusDays(1).atStartOfDay()
    );

    long mes = agendamentoRepository.countByDataHoraBetween(
      LocalDate.now().withDayOfMonth(1).atStartOfDay(),
      LocalDate.now().plusMonths(1).withDayOfMonth(1).atStartOfDay()
    );

    BigDecimal faturamentoMes = agendamentoRepository.sumPrecoByMes(
      LocalDate.now().getYear(),
      LocalDate.now().getMonthValue()
    );

    var proximos =  agendamentoRepository.findTop5ByOrderByDataHoraAsc()
        .stream()
      .map(a -> new ProximoAgendamento(
        a.getId(),
        a.getNome(),
        a.getProcedimento(),
        a.getDataHora()

      ))
        .collect(Collectors.toList());

    return new DashboardResponse(hoje, mes, faturamentoMes, proximos);

  }

}

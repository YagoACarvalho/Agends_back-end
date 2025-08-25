package Agends.Agendamentos.controller;

import Agends.Agendamentos.dto.ConfigHorarioDiaFuncionamentoRequest;
import Agends.Agendamentos.service.ConfiguracaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configuracoes")
public class ConfiguracoesController {

  @Autowired
  private ConfiguracaoService configuracaoService;


  @PutMapping("/{id}")
  public ConfigHorarioDiaFuncionamentoRequest salvarConfiguracao(@PathVariable Long id, @RequestBody @Valid ConfigHorarioDiaFuncionamentoRequest dto) {
    return configuracaoService.salvarConfiguracao(id, dto);
  }



}

package Agends.Agendamentos.service;

import Agends.Agendamentos.Entity.Configuracao;
import Agends.Agendamentos.dto.ConfigHorarioDiaFuncionamentoRequest;
import Agends.Agendamentos.infra.validadorDeErros.ValidacaoException;
import Agends.Agendamentos.repository.ConfiguracaoRepository;
import Agends.Agendamentos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfiguracaoService {

  @Autowired
  private UsuarioRepository usuarioRepository;
  @Autowired
  private ConfiguracaoRepository configuracaoRepository;


  public ConfigHorarioDiaFuncionamentoRequest salvarConfiguracao(Long usuarioId, ConfigHorarioDiaFuncionamentoRequest dto) {
    var usuario = usuarioRepository.findById(usuarioId)
      .orElseThrow(() -> new ValidacaoException("Usuário não encontrado"));

    Configuracao config = usuario.getConfiguracao();

    if (config == null) {
      config = new Configuracao();
      usuario.setConfiguracao(config);
    }

    config.setHorarioAbertura(dto.horarioAbertura());
    config.setHorarioFechamento(dto.horarioFechamento());
    config.setDiaSemana(dto.diaSemana());


    usuarioRepository.save(usuario);

    return dto;

  }
}

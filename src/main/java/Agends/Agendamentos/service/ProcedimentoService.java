package Agends.Agendamentos.service;

import Agends.Agendamentos.Entity.Procedimento;
import Agends.Agendamentos.dto.ProcedimentoResponse;
import Agends.Agendamentos.dto.ProcedimentoRequest;
import Agends.Agendamentos.infra.validadorDeErros.ValidacaoException;
import Agends.Agendamentos.repository.ProcedimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProcedimentoService {

  @Autowired
  private ProcedimentosRepository procedimentosRepository;


  @Transactional
  public ProcedimentoResponse adicionar(ProcedimentoRequest dadosProcedimento) {

    if (procedimentosRepository.existsByServico(dadosProcedimento.servico())){
      throw new ValidacaoException("Já exite um procedimento com esse nome");
    }

    var procedimento = new Procedimento(null, dadosProcedimento.servico(), dadosProcedimento.preco(), dadosProcedimento.duracao());
    procedimentosRepository.save(procedimento);

    return new ProcedimentoResponse(procedimento);
  }


}

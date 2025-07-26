package Agends.Agendamentos.controller;

import Agends.Agendamentos.dto.ProcedimentoRequest;
import Agends.Agendamentos.dto.ProcedimentoResponse;
import Agends.Agendamentos.infra.validadorDeErros.ValidacaoException;
import Agends.Agendamentos.repository.ProcedimentosRepository;
import Agends.Agendamentos.service.ProcedimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/procedimentos")
public class ProcedimentoController {

  @Autowired
  private ProcedimentosRepository procedimentosRepository;

  @Autowired
  private ProcedimentoService procedimentoService;

  @PostMapping
  @Transactional
  public ResponseEntity criarProcedimento(@RequestBody @Valid ProcedimentoRequest dadosProcedimento) {
    var dto = procedimentoService.adicionar(dadosProcedimento);
    return ResponseEntity.ok(dto);
  }

  @GetMapping
  public ResponseEntity<Page<ProcedimentoResponse>> listarProcedimentos(Pageable pageable) {
    var page = procedimentosRepository.findAll(pageable).map(ProcedimentoResponse::new);
    return ResponseEntity.ok(page);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deletarProcedimento(@PathVariable Long id){
    var procedimento = procedimentosRepository.findById(id)
        .orElseThrow(() -> new ValidacaoException("Procedimento não encontrado!"));
    procedimentosRepository.delete(procedimento);
    return ResponseEntity.ok("Procedimento deletado com sucesso!");
  }




}

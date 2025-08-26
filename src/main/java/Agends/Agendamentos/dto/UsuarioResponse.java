package Agends.Agendamentos.dto;

import Agends.Agendamentos.Entity.Configuracao;
import Agends.Agendamentos.Entity.Usuario;

public record UsuarioResponse(
  Long id,
  String username,
  ConfiguracaoResponse configuracao
) {
  public UsuarioResponse(Usuario usuario) {
    this(usuario.getId(), usuario.getUsername(), new ConfiguracaoResponse(usuario.getConfiguracao()));
  }
}

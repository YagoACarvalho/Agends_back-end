package Agends.Agendamentos.dto;

import Agends.Agendamentos.Entity.Configuracao;
import Agends.Agendamentos.Entity.Usuario;

public record UsuarioResponse(
  Long id,
  String username,
  Configuracao configuracao
) {
  public UsuarioResponse(Usuario usuario) {
    this(usuario.getId(), usuario.getUsername(), usuario.getConfiguracao());
  }
}

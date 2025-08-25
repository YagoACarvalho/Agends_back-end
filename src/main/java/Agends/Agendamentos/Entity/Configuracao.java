package Agends.Agendamentos.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "configuracoes")
public class Configuracao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "usuario_id", nullable = false)
  private Usuario usuario;

  private LocalTime horarioAbertura;
  private LocalTime horarioFechamento;

  @Enumerated(EnumType.STRING)
  private DiaSemana diaSemana;

  private boolean ativo;

  public Configuracao(Long id, Usuario usuario, LocalTime horarioAbertura, LocalTime horarioFechamento, DiaSemana diaSemana, boolean ativo) {
    this.id = id;
    this.usuario = usuario;
    this.horarioAbertura = horarioAbertura;
    this.horarioFechamento = horarioFechamento;
    this.diaSemana = diaSemana;
    this.ativo = ativo;
  }
}

package Agends.Agendamentos.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Configuracao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  private Usuario usuario;

  private LocalTime horarioAbertura;
  private LocalTime horarioFechamento;

}

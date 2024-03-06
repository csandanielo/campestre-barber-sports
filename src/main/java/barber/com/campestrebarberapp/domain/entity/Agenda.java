package barber.com.campestrebarberapp.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Table
@Entity
public class Agenda {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "tipo_servico")
    private String tipoServico;
    @Column (name = "id_barbeiro")
    private Long idBarbeiro;
    @Column (name = "data_hora")
    private LocalDate dataAgendamento;
    @Column (name = "data_criacao")
    private LocalDate dataAgenda;
    @ManyToOne
    private Cliente cliente;

}

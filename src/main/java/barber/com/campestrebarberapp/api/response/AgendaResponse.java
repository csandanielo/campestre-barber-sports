package barber.com.campestrebarberapp.api.response;

import barber.com.campestrebarberapp.domain.entity.Cliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendaResponse {

    private Long id;
    private String tipoServico;
    private Long idBarbeiro;
    private LocalDateTime dataHoraAgendamento;
    private ClienteResponse cliente;
}

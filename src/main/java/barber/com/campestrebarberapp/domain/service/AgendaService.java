package barber.com.campestrebarberapp.domain.service;

import barber.com.campestrebarberapp.domain.entity.Agenda;
import barber.com.campestrebarberapp.domain.entity.Cliente;
import barber.com.campestrebarberapp.domain.repository.AgendaRepository;
import barber.com.campestrebarberapp.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AgendaService {

    private final AgendaRepository repository;
    private final ClienteService clienteService;

    public List<Agenda> listarTodos() {
        return repository.findAll();
    }

    public Optional<Agenda> buscarPorId(Long id) {
        return repository.findById(id);

    }

    public Agenda salvar(Agenda agenda) {
        Optional<Cliente> optCliente = clienteService.buscarPorId(agenda.getCliente().getId());

        if (optCliente.isEmpty()) {
            throw new BusinessException("Cliente não encontrado");
        }

        Optional<Agenda> optDataHoraAgendamento = repository.findByDataHoraAgendamento(agenda.getDataHoraAgendamento());

        if (optDataHoraAgendamento.isPresent()) {
            throw new BusinessException("Horário não disponível");
        }

        Optional<Agenda> optIdBarbeiro = repository.findByIdBarbeiro(agenda.getIdBarbeiro());

        if (optIdBarbeiro.isPresent()) {
            throw new BusinessException("Barbeiro não disponível");
        }

        agenda.setCliente(optCliente.get());
        agenda.setDataAgenda(LocalDateTime.now());
        agenda.setIdBarbeiro(agenda.getIdBarbeiro());
        agenda.setTipoServico(agenda.getTipoServico());

        return repository.save(agenda);

    }

}

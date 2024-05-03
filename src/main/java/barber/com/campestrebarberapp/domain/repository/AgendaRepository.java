package barber.com.campestrebarberapp.domain.repository;

import barber.com.campestrebarberapp.domain.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    Optional<Agenda> findById(Long id);

    Optional<Agenda> findByDataHoraAgendamento(LocalDateTime dataHoraAgendamento);

    Optional<Agenda> findByIdBarbeiro(Long idBarbeiro);
}

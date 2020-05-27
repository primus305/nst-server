package nst.projekat.repository;

import nst.projekat.domain.AgendaSession;
import nst.projekat.domain.AgendaSessionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaSessionRepository extends JpaRepository<AgendaSession, AgendaSessionPK> {
    List<AgendaSession> findAllByAgendaID(Long agendaID);
    List<AgendaSession> findAllBySuperSession(AgendaSession agendaSession);
}

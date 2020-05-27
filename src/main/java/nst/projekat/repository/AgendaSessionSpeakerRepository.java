package nst.projekat.repository;

import nst.projekat.domain.AgendaSessionSpeaker;
import nst.projekat.domain.AgendaSessionSpeakerPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AgendaSessionSpeakerRepository extends JpaRepository<AgendaSessionSpeaker, AgendaSessionSpeakerPK> {
    Set<AgendaSessionSpeaker> findAllByAgendaIDAndSessionID(Long agendaID, Long sessionID);
    Set<AgendaSessionSpeaker> findAllBySpeakerID(Long speakerID);

}

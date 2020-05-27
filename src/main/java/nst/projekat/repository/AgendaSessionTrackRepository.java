package nst.projekat.repository;

import nst.projekat.domain.AgendaSessionTrack;
import nst.projekat.domain.AgendaSessionTrackPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AgendaSessionTrackRepository extends JpaRepository<AgendaSessionTrack, AgendaSessionTrackPK> {
    Set<AgendaSessionTrack> findAllByAgendaIDAndSessionID(Long agendaID, Long sessionID);
}

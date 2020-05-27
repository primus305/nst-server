package nst.projekat.repository;

import nst.projekat.domain.AgendaSessionSpeaker;
import nst.projekat.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findByAgenda_AgendaID(Long agendaID);
    @Query(value = "FROM Event AS e JOIN AgendaSessionSpeaker AS ass ON e.agenda.agendaID = ass.agendaID WHERE ass.speakerID=?1 GROUP BY ass.agendaID")
    List<Event> findAllBySpeakerGroupByAgenda(Long speakerID);
}

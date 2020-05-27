package nst.projekat.service;

import nst.projekat.dto.AgendaSessionTrackDTO;

import java.util.List;
import java.util.Set;

public interface AgendaSessionTrackService {
    AgendaSessionTrackDTO save(AgendaSessionTrackDTO agendaSessionTrackDTO);
    Set<AgendaSessionTrackDTO> findAllByAgendaAndSession(Long agendaID, Long sessionID);
    void delete(AgendaSessionTrackDTO agendaSessionTrackDTO);
}

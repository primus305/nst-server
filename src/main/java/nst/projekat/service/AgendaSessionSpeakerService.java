package nst.projekat.service;

import nst.projekat.domain.AgendaSessionSpeakerPK;
import nst.projekat.dto.AgendaSessionSpeakerDTO;

import java.util.Set;

public interface AgendaSessionSpeakerService {
    AgendaSessionSpeakerDTO save(AgendaSessionSpeakerDTO agendaSessionSpeakerDTO);
    Set<AgendaSessionSpeakerDTO> findAllByAgendaAndSession(Long agendaID, Long sessionID);
    void delete(AgendaSessionSpeakerDTO agendaSessionSpeakerDTO);
    Set<AgendaSessionSpeakerDTO> findAllBySpeaker(Long speakerID);
    AgendaSessionSpeakerDTO findById(AgendaSessionSpeakerPK id);
}

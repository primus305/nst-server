package nst.projekat.service.impl;

import nst.projekat.domain.AgendaSessionSpeaker;
import nst.projekat.domain.AgendaSessionSpeakerPK;
import nst.projekat.domain.Event;
import nst.projekat.domain.UserSession;
import nst.projekat.dto.AgendaSessionSpeakerDTO;
import nst.projekat.dto.EventDTO;
import nst.projekat.mapper.AgendaSessionSpeakerMapper;
import nst.projekat.mapper.AgendaSessionTrackMapper;
import nst.projekat.mapper.EventMapper;
import nst.projekat.mapper.UserSessionMapper;
import nst.projekat.repository.AgendaSessionSpeakerRepository;
import nst.projekat.repository.EventRepository;
import nst.projekat.service.AgendaSessionSpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AgendaSessionSpeakerServiceImpl implements AgendaSessionSpeakerService {
    @Autowired
    private AgendaSessionSpeakerRepository agendaSessionSpeakerRepository;
    @Autowired
    private EventRepository eventRepository;

    @Override
    public AgendaSessionSpeakerDTO save(AgendaSessionSpeakerDTO agendaSessionSpeakerDTO) {
        AgendaSessionSpeaker agendaSessionSpeaker = AgendaSessionSpeakerMapper.INSTANCE.agendaSessionSpeakerDTOToAgendaSessionSpeaker(agendaSessionSpeakerDTO);
        return AgendaSessionSpeakerMapper.INSTANCE.agendaSessionSpeakerToAgendaSessionSpeakerDTO(agendaSessionSpeakerRepository.save(agendaSessionSpeaker));
    }

    @Override
    public Set<AgendaSessionSpeakerDTO> findAllByAgendaAndSession(Long agendaID, Long sessionID) {
        return AgendaSessionSpeakerMapper.INSTANCE.toAgendaSessionSpeakerDTOs(agendaSessionSpeakerRepository.findAllByAgendaIDAndSessionID(agendaID, sessionID));
    }

    @Override
    public void delete(AgendaSessionSpeakerDTO agendaSessionSpeakerDTO) {
        agendaSessionSpeakerRepository.delete(AgendaSessionSpeakerMapper.INSTANCE.agendaSessionSpeakerDTOToAgendaSessionSpeaker(agendaSessionSpeakerDTO));
    }

    @Override
    public Set<AgendaSessionSpeakerDTO> findAllBySpeaker(Long speakerID) {
        return AgendaSessionSpeakerMapper.INSTANCE.toAgendaSessionSpeakerDTOs(agendaSessionSpeakerRepository.findAllBySpeakerID(speakerID));
    }

    @Override
    public AgendaSessionSpeakerDTO findById(AgendaSessionSpeakerPK id) {
        Optional<AgendaSessionSpeaker> sessionSpeaker = agendaSessionSpeakerRepository.findById(id);
        if(sessionSpeaker.isPresent()) {
            return AgendaSessionSpeakerMapper.INSTANCE.agendaSessionSpeakerToAgendaSessionSpeakerDTO(sessionSpeaker.get());
        }
        return null;
    }

/*    @Override
    public List<EventDTO> findAllBySpeakerGroupByAgenda(Long speakerID) {
        return EventMapper.INSTANCE.toEventDTOs(agendaSessionSpeakerRepository.findAllBySpeakerGroupByAgenda(speakerID));
    }*/
}

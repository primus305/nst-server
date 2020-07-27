package nst.projekat.service.impl;

import nst.projekat.domain.Agenda;
import nst.projekat.domain.AgendaSession;
import nst.projekat.domain.AgendaSessionPK;
import nst.projekat.dto.AgendaSessionDTO;
import nst.projekat.mapper.AgendaMapper;
import nst.projekat.mapper.AgendaSessionMapper;
import nst.projekat.repository.AgendaSessionRepository;
import nst.projekat.repository.AgendaSessionSpeakerRepository;
import nst.projekat.service.AgendaSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaSessionServiceImpl implements AgendaSessionService {
    @Autowired
    private AgendaSessionRepository agendaSessionRepository;

    @Override
    public AgendaSessionDTO save(AgendaSessionDTO agendaSessionDTO) {
        AgendaSession agendaSession = AgendaSessionMapper.INSTANCE.agendaSessionDTOToAgendaSession(agendaSessionDTO);
        return AgendaSessionMapper.INSTANCE.agendaSessionToAgendaSessionDTO(agendaSessionRepository.save(agendaSession));
    }

    @Override
    public List<AgendaSessionDTO> findAll() {
        return AgendaSessionMapper.INSTANCE.toAgendaSessionDTOs(agendaSessionRepository.findAll());
    }

    @Override
    public List<AgendaSessionDTO> findAllByAgenda(Long agendaID) {
        return AgendaSessionMapper.INSTANCE.toAgendaSessionDTOs(agendaSessionRepository.findAllByAgendaID(agendaID));
    }

    @Override
    public AgendaSessionDTO findById(AgendaSessionPK id) {
        Optional<AgendaSession> as = agendaSessionRepository.findById(id);
        if(as.isPresent()) {
            AgendaSessionDTO agendaSessionDTO = AgendaSessionMapper.INSTANCE.agendaSessionToAgendaSessionDTO(as.get());
            List<AgendaSessionDTO> subSessions = AgendaSessionMapper.INSTANCE.toAgendaSessionDTOs(agendaSessionRepository.findAllBySuperSession(as.get()));
            agendaSessionDTO.setSubSessions(subSessions);
            return agendaSessionDTO;
        }
        return null;
    }

    @Override
    public List<AgendaSessionDTO> findAllBySuperSession(AgendaSessionDTO agendaSessionDTO) {
        AgendaSession superSession = AgendaSessionMapper.INSTANCE.agendaSessionDTOToAgendaSession(agendaSessionDTO);
        return AgendaSessionMapper.INSTANCE.toAgendaSessionDTOs(agendaSessionRepository.findAllBySuperSession(superSession));
    }

    @Override
    public AgendaSessionDTO update(AgendaSessionDTO agendaSessionDTO) {
        Optional<AgendaSession> agendaSession = agendaSessionRepository.findById(new AgendaSessionPK(agendaSessionDTO.getSessionID(), agendaSessionDTO.getAgendaID()));

//        if (agendaSession.isPresent()) {
//            AgendaSession updateAgendaSession = AgendaSessionMapper.INSTANCE.agendaSessionDTOToAgendaSession(agendaSessionDTO);
//            updateAgendaSession.getSpeakers().forEach(agendaSessionSpeaker -> {
//                if (agendaSession.get().getSpeakers().contains(agendaSession))
//            });
//        }

        return AgendaSessionMapper.INSTANCE.agendaSessionToAgendaSessionDTO(agendaSessionRepository.save(agendaSession.get()));
    }


}

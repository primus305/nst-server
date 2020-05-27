package nst.projekat.service.impl;

import nst.projekat.domain.Agenda;
import nst.projekat.domain.AgendaSession;
import nst.projekat.domain.AgendaSessionPK;
import nst.projekat.dto.AgendaSessionDTO;
import nst.projekat.mapper.AgendaMapper;
import nst.projekat.mapper.AgendaSessionMapper;
import nst.projekat.repository.AgendaSessionRepository;
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
            return AgendaSessionMapper.INSTANCE.agendaSessionToAgendaSessionDTO(as.get());
        }
        return null;
    }

    @Override
    public List<AgendaSessionDTO> findAllBySuperSession(AgendaSessionDTO agendaSessionDTO) {
        AgendaSession superSession = AgendaSessionMapper.INSTANCE.agendaSessionDTOToAgendaSession(agendaSessionDTO);
        return AgendaSessionMapper.INSTANCE.toAgendaSessionDTOs(agendaSessionRepository.findAllBySuperSession(superSession));
    }


}

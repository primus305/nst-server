package nst.projekat.service.impl;

import nst.projekat.domain.Agenda;
import nst.projekat.dto.AgendaDTO;
import nst.projekat.mapper.AgendaMapper;
import nst.projekat.repository.AgendaRepository;
import nst.projekat.repository.AgendaSessionRepository;
import nst.projekat.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private AgendaSessionRepository agendaSessionRepository;

    @Override
    public AgendaDTO save(AgendaDTO agendaDTO) {
        Agenda agenda = AgendaMapper.INSTANCE.agendaDTOToAgenda(agendaDTO);
        agendaRepository.save(agenda);
        agenda.getSessions().forEach(agendaSession -> {
            agendaSessionRepository.save(agendaSession);
        });
        return AgendaMapper.INSTANCE.agendaToAgendaDTO(agenda);
    }

    @Override
    public AgendaDTO findById(Long id) {
        Optional<Agenda> agenda = agendaRepository.findById(id);
        if(agenda.isPresent()) {
            return AgendaMapper.INSTANCE.agendaToAgendaDTO(agenda.get());
        }
        return null;
    }

    @Override
    public List<AgendaDTO> findAll() {
        return AgendaMapper.INSTANCE.toAgendaDTOs(agendaRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        agendaRepository.deleteById(id);
    }

    @Override
    public Long nextID() {
        Long maxID = agendaRepository.maxID();
        if(maxID != null) {
            return maxID;
        }
        return 0l;
    }
}

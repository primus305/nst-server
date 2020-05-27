package nst.projekat.service.impl;

import nst.projekat.domain.AgendaSessionTrack;
import nst.projekat.dto.AgendaSessionTrackDTO;
import nst.projekat.mapper.AgendaSessionTrackMapper;
import nst.projekat.repository.AgendaSessionTrackRepository;
import nst.projekat.service.AgendaSessionTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AgendaSessionTrackServiceImpl implements AgendaSessionTrackService {
    @Autowired
    private AgendaSessionTrackRepository agendaSessionTrackRepository;

    @Override
    public AgendaSessionTrackDTO save(AgendaSessionTrackDTO agendaSessionTrackDTO) {
        AgendaSessionTrack agendaSessionTrack = AgendaSessionTrackMapper.INSTANCE.agendaSessionTrackDTOToAgendaSessionTrack(agendaSessionTrackDTO);
        return AgendaSessionTrackMapper.INSTANCE.agendaSessionTrackToAgendaSessionTrackDTO(agendaSessionTrackRepository.save(agendaSessionTrack));
    }

    @Override
    public Set<AgendaSessionTrackDTO> findAllByAgendaAndSession(Long agendaID, Long sessionID) {
        return AgendaSessionTrackMapper.INSTANCE.toAgendaSessionTrackDTOs(agendaSessionTrackRepository.findAllByAgendaIDAndSessionID(agendaID, sessionID));
    }

    @Override
    public void delete(AgendaSessionTrackDTO agendaSessionTrackDTO) {
        agendaSessionTrackRepository.delete(AgendaSessionTrackMapper.INSTANCE.agendaSessionTrackDTOToAgendaSessionTrack(agendaSessionTrackDTO));
    }


}

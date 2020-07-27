package nst.projekat.service;

import nst.projekat.domain.AgendaSessionPK;
import nst.projekat.dto.AgendaSessionDTO;

import java.util.List;

public interface AgendaSessionService {
    AgendaSessionDTO save(AgendaSessionDTO agendaSessionDTO);

    List<AgendaSessionDTO> findAll();

    List<AgendaSessionDTO> findAllByAgenda(Long agendaID);

    AgendaSessionDTO findById(AgendaSessionPK id);

    List<AgendaSessionDTO> findAllBySuperSession(AgendaSessionDTO agendaSessionDTO);

    AgendaSessionDTO update(AgendaSessionDTO agendaSessionDTO);
}

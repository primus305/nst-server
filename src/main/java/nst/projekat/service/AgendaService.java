package nst.projekat.service;

import nst.projekat.domain.Agenda;
import nst.projekat.dto.AgendaDTO;

import java.util.List;

public interface AgendaService {

    AgendaDTO save(AgendaDTO agendaDTO);

    AgendaDTO findById(Long id);

    List<AgendaDTO> findAll();

    void delete(Long id);

    Long nextID();
}

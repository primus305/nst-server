package nst.projekat.service;

import nst.projekat.dto.EventDTO;

import java.util.List;

public interface EventService {
    EventDTO save(EventDTO eventDTO);
    EventDTO findById(Long id);
    List<EventDTO> findAll();
    EventDTO findByAgenda(Long agendaID);
    List<EventDTO> findAllBySpeakerGroupByAgenda(Long agendaID);
}

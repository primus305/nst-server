package nst.projekat.service.impl;

import nst.projekat.domain.Event;
import nst.projekat.dto.EventDTO;
import nst.projekat.mapper.EventMapper;
import nst.projekat.repository.EventRepository;
import nst.projekat.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventDTO save(EventDTO eventDTO) {
        Event event = eventRepository.save(EventMapper.INSTANCE.eventDTOToEvent(eventDTO));
        return EventMapper.INSTANCE.eventToEventDTO(event);
    }

    @Override
    public EventDTO findById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if(event.isPresent()) {
            return EventMapper.INSTANCE.eventToEventDTO(event.get());
        }
        return null;
    }

    @Override
    public List<EventDTO> findAll() {
        return EventMapper.INSTANCE.toEventDTOs(eventRepository.findAll());
    }

    @Override
    public EventDTO findByAgenda(Long agendaID) {
        return EventMapper.INSTANCE.eventToEventDTO(eventRepository.findByAgenda_AgendaID(agendaID));
    }

    @Override
    public List<EventDTO> findAllBySpeakerGroupByAgenda(Long agendaID) {
        return EventMapper.INSTANCE.toEventDTOs(eventRepository.findAllBySpeakerGroupByAgenda(agendaID));
    }
}

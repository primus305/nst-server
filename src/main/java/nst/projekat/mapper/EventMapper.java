package nst.projekat.mapper;

import nst.projekat.domain.Event;
import nst.projekat.dto.EventDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    EventDTO eventToEventDTO(Event event);
    Event eventDTOToEvent(EventDTO eventDTO);
    List<EventDTO> toEventDTOs(List<Event> events);
}

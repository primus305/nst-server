package nst.projekat.mapper;

import nst.projekat.domain.AgendaSession;
import nst.projekat.dto.AgendaSessionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgendaSessionMapper {
    AgendaSessionMapper INSTANCE = Mappers.getMapper(AgendaSessionMapper.class);

    @Mapping(target = "timeFrom", source = "agendaSession.timeFrom",
            dateFormat = "EEE MMM dd yyyy HH:mm:ss")
    @Mapping(target = "timeTo", source = "agendaSession.timeTo",
            dateFormat = "EEE MMM dd yyyy HH:mm:ss")
    AgendaSessionDTO agendaSessionToAgendaSessionDTO(AgendaSession agendaSession);

    @Mapping(target = "timeFrom", source = "agendaSessionDTO.timeFrom",
            dateFormat = "EEE MMM dd yyyy HH:mm:ss")
    @Mapping(target = "timeTo", source = "agendaSessionDTO.timeTo",
            dateFormat = "EEE MMM dd yyyy HH:mm:ss")
    AgendaSession agendaSessionDTOToAgendaSession(AgendaSessionDTO agendaSessionDTO);

    List<AgendaSessionDTO> toAgendaSessionDTOs(List<AgendaSession> agendaSessions);
    List<AgendaSession> toAgendaSessions(List<AgendaSessionDTO> agendaSessionsDTO);
}

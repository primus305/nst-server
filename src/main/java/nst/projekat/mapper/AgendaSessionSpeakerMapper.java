package nst.projekat.mapper;

import nst.projekat.domain.AgendaSession;
import nst.projekat.domain.AgendaSessionSpeaker;
import nst.projekat.domain.AgendaSessionTrack;
import nst.projekat.dto.AgendaSessionDTO;
import nst.projekat.dto.AgendaSessionSpeakerDTO;
import nst.projekat.dto.AgendaSessionTrackDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface AgendaSessionSpeakerMapper {
    AgendaSessionSpeakerMapper INSTANCE = Mappers.getMapper(AgendaSessionSpeakerMapper.class);

    @Mapping(target = "agendaSessionName", source = "agendaSessionSpeaker.agendaSession.name")
    @Mapping(target = "agendaSessionTimeFrom", source = "agendaSessionSpeaker.agendaSession.timeFrom",
            dateFormat = "EEE MMM dd yyyy HH:mm:ss")
    @Mapping(target = "agendaSessionTimeTo", source = "agendaSessionSpeaker.agendaSession.timeTo",
            dateFormat = "EEE MMM dd yyyy HH:mm:ss")
    AgendaSessionSpeakerDTO agendaSessionSpeakerToAgendaSessionSpeakerDTO(AgendaSessionSpeaker agendaSessionSpeaker);
    AgendaSessionSpeaker agendaSessionSpeakerDTOToAgendaSessionSpeaker(AgendaSessionSpeakerDTO agendaSessionSpeakerDTO);
    Set<AgendaSessionSpeakerDTO> toAgendaSessionSpeakerDTOs(Set<AgendaSessionSpeaker> agendaSessionSpeakers);
}

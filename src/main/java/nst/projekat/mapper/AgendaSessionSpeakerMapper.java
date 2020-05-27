package nst.projekat.mapper;

import nst.projekat.domain.AgendaSessionSpeaker;
import nst.projekat.domain.AgendaSessionTrack;
import nst.projekat.dto.AgendaSessionSpeakerDTO;
import nst.projekat.dto.AgendaSessionTrackDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface AgendaSessionSpeakerMapper {
    AgendaSessionSpeakerMapper INSTANCE = Mappers.getMapper(AgendaSessionSpeakerMapper.class);

    AgendaSessionSpeakerDTO agendaSessionSpeakerToAgendaSessionSpeakerDTO(AgendaSessionSpeaker agendaSessionSpeaker);
    AgendaSessionSpeaker agendaSessionSpeakerDTOToAgendaSessionSpeaker(AgendaSessionSpeakerDTO agendaSessionSpeakerDTO);
    Set<AgendaSessionSpeakerDTO> toAgendaSessionSpeakerDTOs(Set<AgendaSessionSpeaker> agendaSessionSpeakers);
}

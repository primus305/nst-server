package nst.projekat.mapper;

import nst.projekat.domain.AgendaSessionTrack;
import nst.projekat.dto.AgendaSessionTrackDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface AgendaSessionTrackMapper {
    AgendaSessionTrackMapper INSTANCE = Mappers.getMapper(AgendaSessionTrackMapper.class);

    AgendaSessionTrackDTO agendaSessionTrackToAgendaSessionTrackDTO(AgendaSessionTrack agendaSessionTrack);
    AgendaSessionTrack agendaSessionTrackDTOToAgendaSessionTrack(AgendaSessionTrackDTO agendaSessionTrackDTO);
    Set<AgendaSessionTrackDTO> toAgendaSessionTrackDTOs(Set<AgendaSessionTrack> agendaSessionTracks);
}

package nst.projekat.mapper;

import nst.projekat.domain.AgendaSessionTrack;
import nst.projekat.domain.Presence;
import nst.projekat.dto.AgendaSessionTrackDTO;
import nst.projekat.dto.PresenceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface PresenceMapper {
    PresenceMapper INSTANCE = Mappers.getMapper(PresenceMapper.class);

    PresenceDTO presenceToPresenceDTO(Presence presence);
    Presence presenceDTOToPresence(PresenceDTO presenceDTO);
    Set<PresenceDTO> toPresenceDTOs(Set<Presence> presences);
}

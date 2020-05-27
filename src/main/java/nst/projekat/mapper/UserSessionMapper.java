package nst.projekat.mapper;

import nst.projekat.domain.AgendaSessionSpeaker;
import nst.projekat.domain.UserSession;
import nst.projekat.dto.AgendaSessionSpeakerDTO;
import nst.projekat.dto.UserSessionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserSessionMapper {
    UserSessionMapper INSTANCE = Mappers.getMapper(UserSessionMapper.class);

    UserSessionDTO userSessionToUserSessionDTO(UserSession userSession);
    UserSession userSessionDTOToUserSession(UserSessionDTO userSessionDTO);
    Set<UserSessionDTO> toUserSessionDTOs(Set<UserSession> userSessions);
}

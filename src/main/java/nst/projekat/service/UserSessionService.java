package nst.projekat.service;

import nst.projekat.domain.UserSessionPK;
import nst.projekat.dto.UserSessionDTO;

import java.util.Set;

public interface UserSessionService {
    UserSessionDTO save(UserSessionDTO userSessionDTO);
    Set<UserSessionDTO> findAllByAgendaAndSession(Long agendaID, Long sessionID);
    void deleteById(UserSessionPK userSessionPK);
    UserSessionDTO findById(UserSessionPK userSessionPK);
    Set<UserSessionDTO> findByUser(Long userID);
}

package nst.projekat.service.impl;

import nst.projekat.domain.UserSession;
import nst.projekat.domain.UserSessionPK;
import nst.projekat.dto.UserSessionDTO;
import nst.projekat.mapper.UserSessionMapper;
import nst.projekat.repository.UserSessionRepository;
import nst.projekat.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserSessionServiceImpl implements UserSessionService {
    @Autowired
    private UserSessionRepository userSessionRepository;

    @Override
    public UserSessionDTO save(UserSessionDTO userSessionDTO) {
        UserSession userSession = UserSessionMapper.INSTANCE.userSessionDTOToUserSession(userSessionDTO);
        return UserSessionMapper.INSTANCE.userSessionToUserSessionDTO(userSessionRepository.save(userSession));
    }

    @Override
    public Set<UserSessionDTO> findAllByAgendaAndSession(Long agendaID, Long sessionID) {
        return UserSessionMapper.INSTANCE.toUserSessionDTOs(userSessionRepository.findAllByAgendaIDAndSessionID(agendaID, sessionID));
    }

    @Override
    public void deleteById(UserSessionPK userSessionPK) {
        userSessionRepository.deleteById(userSessionPK);
    }

    @Override
    public UserSessionDTO findById(UserSessionPK userSessionPK) {
        Optional<UserSession> userSession = userSessionRepository.findById(userSessionPK);
        if(userSession.isPresent()) {
            return UserSessionMapper.INSTANCE.userSessionToUserSessionDTO(userSession.get());
        }
        return null;
    }

    @Override
    public Set<UserSessionDTO> findByUser(Long userID) {
        return UserSessionMapper.INSTANCE.toUserSessionDTOs(userSessionRepository.findAllByUserID(userID));
    }
}

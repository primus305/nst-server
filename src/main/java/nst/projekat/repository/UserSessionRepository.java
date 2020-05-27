package nst.projekat.repository;

import nst.projekat.domain.UserSession;
import nst.projekat.domain.UserSessionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, UserSessionPK> {
    Set<UserSession> findAllByAgendaIDAndSessionID(Long agendaID, Long sessionID);
    Set<UserSession> findAllByUserID(Long userID);
    List<UserSession> findAllByUserIDAndEventID(Long userID, Long eventID);
}

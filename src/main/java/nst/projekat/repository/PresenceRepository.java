package nst.projekat.repository;

import nst.projekat.domain.Presence;
import nst.projekat.domain.PresencePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PresenceRepository extends JpaRepository<Presence, PresencePK> {
    Set<Presence> findAllByEventID(Long eventID);
    Set<Presence> findAllByUserID(Long userID);
}

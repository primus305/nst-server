package nst.projekat.repository;

import nst.projekat.domain.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
    Speaker findByEmail(String email);
    Speaker findByUsername(String username);
}

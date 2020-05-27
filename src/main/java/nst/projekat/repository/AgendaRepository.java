package nst.projekat.repository;

import nst.projekat.domain.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    @Query(value = "SELECT MAX(agendaID) FROM Agenda")
    public Long maxID();
}

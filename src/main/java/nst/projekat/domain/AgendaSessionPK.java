package nst.projekat.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

public class AgendaSessionPK implements Serializable {
    Long sessionID;
    Long agendaID;

    public AgendaSessionPK(Long sessionID, Long agendaID) {
        this.sessionID = sessionID;
        this.agendaID = agendaID;
    }

    public AgendaSessionPK() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgendaSessionPK that = (AgendaSessionPK) o;
        return Objects.equals(sessionID, that.sessionID) &&
                Objects.equals(agendaID, that.agendaID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionID, agendaID);
    }
}

package nst.projekat.domain;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class UserSessionPK implements Serializable {
    Long sessionID;
    Long agendaID;
    @Column(name = "userID")
    Long userID;
    @Column(name = "eventID")
    Long eventID;

    public UserSessionPK(Long sessionID, Long agendaID, Long userID, Long eventID) {
        this.sessionID = sessionID;
        this.agendaID = agendaID;
        this.userID = userID;
        this.eventID = eventID;
    }

    public UserSessionPK() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSessionPK that = (UserSessionPK) o;
        return Objects.equals(sessionID, that.sessionID) &&
                Objects.equals(agendaID, that.agendaID) &&
                Objects.equals(userID, that.userID) &&
                Objects.equals(eventID, that.eventID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionID, agendaID, userID, eventID);
    }
}

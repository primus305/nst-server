package nst.projekat.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(UserSessionPK.class)
public class UserSession implements Serializable {
    @Id
    private Long sessionID;
    @Id
    private Long agendaID;
    @Id
    private Long userID;
    @Id
    private Long eventID;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("agendaSession")
    @JoinColumns({
            @JoinColumn(name = "agendaID"),
            @JoinColumn(name = "sessionID")
    })
    AgendaSession agendaSession;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("presence")
    @JoinColumns({
            @JoinColumn(name = "eventID"),
            @JoinColumn(name = "userID")
    })
    Presence presence;

    public Long getSessionID() {
        return sessionID;
    }

    public void setSessionID(Long sessionID) {
        this.sessionID = sessionID;
    }

    public Long getAgendaID() {
        return agendaID;
    }

    public void setAgendaID(Long agendaID) {
        this.agendaID = agendaID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getEventID() {
        return eventID;
    }

    public void setEventID(Long eventID) {
        this.eventID = eventID;
    }

    public AgendaSession getAgendaSession() {
        return agendaSession;
    }

    public void setAgendaSession(AgendaSession agendaSession) {
        this.agendaSession = agendaSession;
    }

    public Presence getPresence() {
        return presence;
    }

    public void setPresence(Presence presence) {
        this.presence = presence;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "sessionID=" + sessionID +
                ", agendaID=" + agendaID +
                ", userID=" + userID +
                ", eventID=" + eventID +
                ", agendaSession=" + agendaSession +
                ", presence=" + presence +
                '}';
    }
}

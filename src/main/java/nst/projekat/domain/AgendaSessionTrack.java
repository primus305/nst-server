package nst.projekat.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(AgendaSessionTrackPK.class)
public class AgendaSessionTrack implements Serializable {
    @Id
    private Long sessionID;
    @Id
    private Long agendaID;
    @Id
    private Long trackID;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("agendaSession")
    @JoinColumns({
            @JoinColumn(name = "agendaID"),
            @JoinColumn(name = "sessionID")
    })
    AgendaSession agendaSession;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("trackID")
    @JoinColumn(name = "trackID")
    Track track;

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

    public Long getTrackID() {
        return trackID;
    }

    public void setTrackID(Long trackID) {
        this.trackID = trackID;
    }

    public AgendaSession getAgendaSession() {
        return agendaSession;
    }

    public void setAgendaSession(AgendaSession agendaSession) {
        this.agendaSession = agendaSession;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    @Override
    public String toString() {
        return "AgendaSessionTrack{" +
                "sessionID=" + sessionID +
                ", agendaID=" + agendaID +
                ", trackID=" + trackID +
                ", agendaSession=" + agendaSession +
                ", track=" + track +
                '}';
    }
}

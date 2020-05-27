package nst.projekat.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(AgendaSessionSpeakerPK.class)
public class AgendaSessionSpeaker implements Serializable {
    @Id
    private Long sessionID;
    @Id
    private Long agendaID;
    @Id
    private Long speakerID;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("agendaSession")
    @JoinColumns({
            @JoinColumn(name = "agendaID"),
            @JoinColumn(name = "sessionID")
    })
    AgendaSession agendaSession;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("speakerID")
    @JoinColumn(name = "speakerID")
    Speaker speaker;

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

    public Long getSpeakerID() {
        return speakerID;
    }

    public void setSpeakerID(Long speakerID) {
        this.speakerID = speakerID;
    }

    public AgendaSession getAgendaSession() {
        return agendaSession;
    }

    public void setAgendaSession(AgendaSession agendaSession) {
        this.agendaSession = agendaSession;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public String toString() {
        return "AgendaSessionSpeaker{" +
                "sessionID=" + sessionID +
                ", agendaID=" + agendaID +
                ", speakerID=" + speakerID +
                ", agendaSession=" + agendaSession +
                ", speaker=" + speaker +
                '}';
    }
}

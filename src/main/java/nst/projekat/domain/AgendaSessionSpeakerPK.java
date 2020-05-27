package nst.projekat.domain;

import javax.persistence.Column;
import java.io.Serializable;

public class AgendaSessionSpeakerPK implements Serializable {
    Long sessionID;
    Long agendaID;
    @Column(name = "speakerID")
    Long speakerID;

    public AgendaSessionSpeakerPK(Long sessionID, Long agendaID, Long speakerID) {
        this.sessionID = sessionID;
        this.agendaID = agendaID;
        this.speakerID = speakerID;
    }

    public AgendaSessionSpeakerPK() {
    }
}

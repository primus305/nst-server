package nst.projekat.domain;

import javax.persistence.Column;
import java.io.Serializable;

public class AgendaSessionTrackPK implements Serializable {
    Long sessionID;
    Long agendaID;
    @Column(name = "trackID")
    Long trackID;
}

package nst.projekat.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@IdClass(AgendaSessionPK.class)
public class AgendaSession implements Serializable {

    @Id
    private Long sessionID;
    @Id
    @JoinColumn(name = "agendaID")
    private Long agendaID;
    @ManyToOne(fetch = FetchType.LAZY)
    private AgendaSession superSession;
    @NotNull
    private String name;
    @NotNull
    private Date timeFrom;
    @NotNull
    private Date timeTo;
    @ManyToOne(fetch = FetchType.EAGER)
    private Hall hall;
    private String sessionOverview;
    @OneToMany(mappedBy = "agendaSession", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AgendaSessionTrack> tracks;
    @OneToMany(mappedBy = "agendaSession", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AgendaSessionSpeaker> speakers;
    @ManyToOne(fetch = FetchType.EAGER)
    private File file;


    public AgendaSession() {
    }

    public AgendaSession(Long sessionID, Long agendaID, AgendaSession superSession, String name, Date timeFrom, Date timeTo, Hall hall, String sessionOverview, Set<AgendaSessionTrack> tracks, Set<AgendaSessionSpeaker> speakers, File file) {
        this.sessionID = sessionID;
        this.agendaID = agendaID;
        this.superSession = superSession;
        this.name = name;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.hall = hall;
        this.sessionOverview = sessionOverview;
        this.tracks = tracks;
        this.speakers = speakers;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Date timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Date getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Date timeTo) {
        this.timeTo = timeTo;
    }

    public String getSessionOverview() {
        return sessionOverview;
    }

    public void setSessionOverview(String sessionOverview) {
        this.sessionOverview = sessionOverview;
    }

    public Long getAgendaID() {
        return agendaID;
    }

    public void setAgendaID(Long agendaID) {
        this.agendaID = agendaID;
    }

    public Long getSessionID() {
        return sessionID;
    }

    public void setSessionID(Long sessionID) {
        this.sessionID = sessionID;
    }

    public AgendaSession getSuperSession() {
        return superSession;
    }

    public void setSuperSession(AgendaSession superSession) {
        this.superSession = superSession;
    }

    public Set<AgendaSessionTrack> getTracks() {
        return tracks;
    }

    public void setTracks(Set<AgendaSessionTrack> tracks) {
        this.tracks = tracks;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Set<AgendaSessionSpeaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Set<AgendaSessionSpeaker> speakers) {
        this.speakers = speakers;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "AgendaSession{" +
                "sessionID=" + sessionID +
                ", agendaID=" + agendaID +
                ", superSession=" + superSession +
                ", name='" + name + '\'' +
                ", timeFrom=" + timeFrom +
                ", timeTo=" + timeTo +
                ", hall=" + hall +
                ", sessionOverview='" + sessionOverview + '\'' +
                ", tracks=" + tracks +
                ", speakers=" + speakers +
                ", file=" + file +
                '}';
    }
}

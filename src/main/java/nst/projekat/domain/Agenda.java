package nst.projekat.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Agenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agendaID;
    @NotNull
    private String name;
    @NotNull
    private Date dateFrom;
    @NotNull
    private Date dateTo;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agendaID")
    @MapKey(name = "agendaID")
    private List<AgendaSession> sessions;

    public Agenda() {
        sessions = new ArrayList<>();
    }

    public Agenda(String name, Date dateFrom, Date dateTo) {
        this.name = name;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        sessions = new ArrayList<>();
    }

    public Long getAgendaID() {
        return agendaID;
    }

    public void setAgendaID(Long agendaID) {
        this.agendaID = agendaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AgendaSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<AgendaSession> sessions) {
        this.sessions = sessions;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void addSession(AgendaSession agendaSession) {
        sessions.add(agendaSession);
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "agendaID=" + agendaID +
                ", name='" + name + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", sessions=" + sessions +
                '}';
    }
}

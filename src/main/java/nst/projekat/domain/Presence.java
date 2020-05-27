package nst.projekat.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(PresencePK.class)
public class Presence implements Serializable {
    @Id
    private Long userID;
    @Id
    private Long eventID;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("userID")
    @JoinColumn(name = "userID")
    User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("eventID")
    @JoinColumn(name = "eventID")
    Event event;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Presence{" +
                "userID=" + userID +
                ", eventID=" + eventID +
                ", user=" + user +
                ", event=" + event +
                '}';
    }
}

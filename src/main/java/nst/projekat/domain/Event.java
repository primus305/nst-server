package nst.projekat.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventID;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String location;
    @ManyToOne(fetch = FetchType.EAGER)
    private File image;
    @OneToOne(fetch = FetchType.LAZY)
    private Agenda agenda;
    @OneToMany(mappedBy = "eventID", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Presence> presences;

    public Event(String name, String description, String location, File image, Agenda agenda, Set<Presence> presences) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.image = image;
        this.agenda = agenda;
        this.presences = presences;
    }

    public Event() {
    }

    public Long getEventID() {
        return eventID;
    }

    public void setEventID(Long eventID) {
        this.eventID = eventID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public Set<Presence> getPresences() {
        return presences;
    }

    public void setPresences(Set<Presence> presences) {
        this.presences = presences;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventID=" + eventID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", image=" + image +
                ", agenda=" + agenda +
                ", presences=" + presences +
                '}';
    }
}

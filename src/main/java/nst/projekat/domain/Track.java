package nst.projekat.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Track implements Serializable {

    @Id
    private Long trackID;
    @NotNull
    private String name;
    private String description;


    public Track() {
    }

    public Track(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getTrackID() {
        return trackID;
    }

    public void setTrackID(Long trackID) {
        this.trackID = trackID;
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

    @Override
    public String toString() {
        return "Track{" +
                "trackID=" + trackID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

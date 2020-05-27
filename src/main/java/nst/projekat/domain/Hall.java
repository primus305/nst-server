package nst.projekat.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Hall implements Serializable {

    @Id
    private Long hallID;
    @NotNull
    private String name;

    public Hall() {
    }

    public Hall(String name) {
        this.name = name;
    }

    public Hall(Long l, String name) {
        this.hallID = l;
        this.name = name;
    }

    public Long getHallID() {
        return hallID;
    }

    public void setHallID(Long hallID) {
        this.hallID = hallID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "hallID=" + hallID +
                ", name='" + name + '\'' +
                '}';
    }

}

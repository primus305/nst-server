package nst.projekat.domain;

import java.io.Serializable;
import java.util.Objects;

public class PresencePK implements Serializable {
    private Long userID;
    private Long eventID;

    public PresencePK(Long userID, Long eventID) {
        this.userID = userID;
        this.eventID = eventID;
    }

    public PresencePK() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresencePK that = (PresencePK) o;
        return Objects.equals(userID, that.userID) &&
                Objects.equals(eventID, that.eventID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, eventID);
    }
}

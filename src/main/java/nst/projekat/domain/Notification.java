package nst.projekat.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Notification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationID;
    private String type;
    private String text;
    private Date date;
    private boolean sent;
    @ManyToOne
    private Presence presence;
}

package nst.projekat.dto;

import lombok.Data;
import nst.projekat.domain.File;

@Data
public class EventDTO {
    private Long eventID;
    private String name;
    private String description;
    private String location;
    private File image;
    private AgendaDTO agenda;
}

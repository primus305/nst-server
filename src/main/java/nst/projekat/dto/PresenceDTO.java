package nst.projekat.dto;

import lombok.Data;

@Data
public class PresenceDTO {
    private Long userID;
    private Long eventID;
    private UserDTO user;
    private EventDTO event;
}

package nst.projekat.dto;

import lombok.Data;

@Data
public class UserSessionDTO {
    private Long sessionID;
    private Long agendaID;
    private Long userID;
    private Long eventID;
    private AgendaSessionDTO agendaSession;
    private PresenceDTO presence;
}

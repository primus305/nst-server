package nst.projekat.dto;

import lombok.Data;

@Data
public class AgendaSessionTrackDTO {
    private Long sessionID;
    private Long agendaID;
    private Long trackID;
    private TrackDTO track;
}

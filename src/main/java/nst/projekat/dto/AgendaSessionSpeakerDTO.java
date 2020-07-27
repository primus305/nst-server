package nst.projekat.dto;

import lombok.Data;

@Data
public class AgendaSessionSpeakerDTO {
    private Long sessionID;
    private Long agendaID;
    private Long speakerID;
    private String agendaSessionName;
    private SpeakerDTO speaker;
    private String agendaSessionTimeFrom;
    private String agendaSessionTimeTo;
}

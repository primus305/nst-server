package nst.projekat.dto;

import lombok.Data;

@Data
public class AgendaSessionSpeakerDTO {
    private Long sessionID;
    private Long agendaID;
    private Long speakerID;
    private AgendaSessionDTO agendaSession;
    private SpeakerDTO speaker;
}

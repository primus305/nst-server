package nst.projekat.dto;

import lombok.Data;
import nst.projekat.domain.File;

import java.util.List;
import java.util.Set;

@Data
public class AgendaSessionDTO {
    private Long sessionID;
    private Long agendaID;
    private AgendaSessionDTO superSession;
    private String name;
    private String  timeFrom;
    private String timeTo;
    private HallDTO hall;
    private String sessionOverview;
    private Set<AgendaSessionTrackDTO> tracks;
    private Set<AgendaSessionSpeakerDTO> speakers;
    private File file;
    private List<AgendaSessionDTO> subSessions;
}

package nst.projekat.dto;

import lombok.Data;

import java.util.List;

@Data
public class AgendaDTO {
    private Long agendaID;
    private String name;
    private String dateFrom;
    private String dateTo;
    private List<AgendaSessionDTO> sessions;
}

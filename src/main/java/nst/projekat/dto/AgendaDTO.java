package nst.projekat.dto;

import lombok.Data;

@Data
public class AgendaDTO {
    private Long agendaID;
    private String name;
    private String dateFrom;
    private String dateTo;
}

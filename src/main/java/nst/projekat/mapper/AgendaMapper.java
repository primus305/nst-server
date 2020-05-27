package nst.projekat.mapper;

import nst.projekat.domain.Agenda;
import nst.projekat.dto.AgendaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgendaMapper {
    AgendaMapper INSTANCE = Mappers.getMapper(AgendaMapper.class);

    @Mapping(target = "dateFrom", source = "agenda.dateFrom",
            dateFormat = "EEE MMM dd yyyy HH:mm:ss")
    @Mapping(target = "dateTo", source = "agenda.dateTo",
            dateFormat = "EEE MMM dd yyyy HH:mm:ss")
    AgendaDTO agendaToAgendaDTO(Agenda agenda);

    @Mapping(target = "dateFrom", source = "agendaDTO.dateFrom",
            dateFormat = "EEE MMM dd yyyy HH:mm:ss")
    @Mapping(target = "dateTo", source = "agendaDTO.dateTo",
            dateFormat = "EEE MMM dd yyyy HH:mm:ss")
    Agenda agendaDTOToAgenda(AgendaDTO agendaDTO);

    List<AgendaDTO> toAgendaDTOs(List<Agenda> agendas);
}

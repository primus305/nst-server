package nst.projekat.mapper;

import nst.projekat.domain.Hall;
import nst.projekat.dto.HallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HallMapper {
    HallMapper INSTANCE = Mappers.getMapper(HallMapper.class);

    HallDTO hallToHallDTO(Hall hall);

    Hall hallDTOToHall(HallDTO hallDTO);

    List<HallDTO> toHallDTOs(List<Hall> halls);
}

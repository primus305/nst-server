package nst.projekat.mapper;

import nst.projekat.domain.Speaker;
import nst.projekat.dto.SpeakerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpeakerMapper {
    SpeakerMapper INSTANCE = Mappers.getMapper(SpeakerMapper.class);

    SpeakerDTO speakerToSpeakerDTO(Speaker speaker);
    Speaker speakerDTOToSpeaker(SpeakerDTO speakerDTO);
    List<SpeakerDTO> toSpeakerDTOs(List<Speaker> speakers);
}

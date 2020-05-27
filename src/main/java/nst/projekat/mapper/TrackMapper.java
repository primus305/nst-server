package nst.projekat.mapper;

import nst.projekat.domain.Track;
import nst.projekat.dto.TrackDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrackMapper {
    TrackMapper INSTANCE = Mappers.getMapper(TrackMapper.class);

    TrackDTO trackToTrackDTO(Track track);
    Track trackDTOToTrack(TrackDTO trackDTO);
    List<TrackDTO> toTrackDTOs(List<Track> tracks);
}

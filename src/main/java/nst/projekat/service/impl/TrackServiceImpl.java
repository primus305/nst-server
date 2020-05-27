package nst.projekat.service.impl;

import nst.projekat.domain.Agenda;
import nst.projekat.domain.Track;
import nst.projekat.dto.TrackDTO;
import nst.projekat.mapper.TrackMapper;
import nst.projekat.repository.TrackRepository;
import nst.projekat.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    @Autowired
    private TrackRepository trackRepository;

    @Override
    public List<TrackDTO> findAll() {
        return TrackMapper.INSTANCE.toTrackDTOs(trackRepository.findAll());
    }

    @Override
    public TrackDTO save(TrackDTO trackDTO) {
        Track track = TrackMapper.INSTANCE.trackDTOToTrack(trackDTO);
        Optional<Track> t = trackRepository.findById(track.getTrackID());
        if(!t.isPresent()) {
            return TrackMapper.INSTANCE.trackToTrackDTO(trackRepository.save(track));
        }
        return null;
    }
}

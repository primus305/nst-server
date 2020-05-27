package nst.projekat.service;

import nst.projekat.dto.TrackDTO;

import java.util.List;

public interface TrackService {
    List<TrackDTO> findAll();
    TrackDTO save(TrackDTO trackDTO);
}

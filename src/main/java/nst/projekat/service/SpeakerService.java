package nst.projekat.service;

import nst.projekat.dto.SpeakerDTO;

import java.util.List;

public interface SpeakerService {
    List<SpeakerDTO> findAll();
    SpeakerDTO save(SpeakerDTO speaker);
}

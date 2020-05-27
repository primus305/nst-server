package nst.projekat.service;

import nst.projekat.dto.HallDTO;

import java.util.List;

public interface HallService {
    List<HallDTO> findAll();

    HallDTO save(HallDTO hallDTO);
}

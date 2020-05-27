package nst.projekat.service.impl;

import nst.projekat.domain.Hall;
import nst.projekat.dto.HallDTO;
import nst.projekat.mapper.HallMapper;
import nst.projekat.repository.HallRepository;
import nst.projekat.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {
    @Autowired
    private HallRepository hallRepository;

    @Override
    public List<HallDTO> findAll() {
        return HallMapper.INSTANCE.toHallDTOs(hallRepository.findAll());
    }

    @Override
    public HallDTO save(HallDTO hallDTO) {
        Hall h = hallRepository.save(HallMapper.INSTANCE.hallDTOToHall(hallDTO));
        return HallMapper.INSTANCE.hallToHallDTO(h);
    }
}

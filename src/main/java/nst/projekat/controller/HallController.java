package nst.projekat.controller;

import nst.projekat.domain.Agenda;
import nst.projekat.domain.Hall;
import nst.projekat.dto.HallDTO;
import nst.projekat.mapper.NotificationMapper;
import nst.projekat.repository.NotificationRepository;
import nst.projekat.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "hall")
@CrossOrigin
public class HallController {
    @Autowired
    private HallService hallService;

    @RequestMapping(value = "all")
    public @ResponseBody
    ResponseEntity findAll() {
        try {
            return ResponseEntity.ok(hallService.findAll());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity save(@RequestBody HallDTO hallDTO) {
        try {
            return ResponseEntity.ok(hallService.save(hallDTO));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}

package nst.projekat.controller;

import nst.projekat.domain.Speaker;
import nst.projekat.domain.Track;
import nst.projekat.dto.SpeakerDTO;
import nst.projekat.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "speaker")
@CrossOrigin
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;

    @RequestMapping(value = "all")
    public @ResponseBody
    ResponseEntity findAll() {
        try {
            return ResponseEntity.ok(speakerService.findAll());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity save(@RequestBody SpeakerDTO speakerDTO) {
        try {
            return ResponseEntity.ok(speakerService.save(speakerDTO));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}

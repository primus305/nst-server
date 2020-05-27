package nst.projekat.controller;

import nst.projekat.domain.Hall;
import nst.projekat.domain.Track;
import nst.projekat.dto.TrackDTO;
import nst.projekat.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "track")
@CrossOrigin
public class TrackController {
    @Autowired
    private TrackService trackService;

    @RequestMapping(value = "all")
    public @ResponseBody
    ResponseEntity findAll() {
        try {
            return ResponseEntity.ok(trackService.findAll());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity save(@RequestBody TrackDTO trackDTO) {
        try {
            return ResponseEntity.ok(trackService.save(trackDTO));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}

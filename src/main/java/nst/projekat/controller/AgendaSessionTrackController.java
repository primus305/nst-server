package nst.projekat.controller;

import nst.projekat.dto.AgendaSessionDTO;
import nst.projekat.dto.AgendaSessionTrackDTO;
import nst.projekat.service.AgendaSessionTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "agendaSessionTrack")
@CrossOrigin
public class AgendaSessionTrackController {
    @Autowired
    private AgendaSessionTrackService agendaSessionTrackService;

    @RequestMapping(value = "saveAll", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity save(@RequestBody List<AgendaSessionTrackDTO> agendaSessionTrackDTOs) {
        try {
            for (AgendaSessionTrackDTO astDTO: agendaSessionTrackDTOs) {
                agendaSessionTrackService.save(astDTO);
            }
            return ResponseEntity.ok(agendaSessionTrackDTOs);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "all/{agendaID}-{sessionID}",method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity findAllBySession(@PathVariable Long agendaID, @PathVariable Long sessionID) {
        try {
            return ResponseEntity.ok(agendaSessionTrackService.findAllByAgendaAndSession(agendaID, sessionID));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "removeAll", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity delete(@RequestBody List<AgendaSessionTrackDTO> agendaSessionTrackDTOs) {
        try {
            for (AgendaSessionTrackDTO astDTO: agendaSessionTrackDTOs) {
                agendaSessionTrackService.delete(astDTO);
            }
            return ResponseEntity.ok(agendaSessionTrackDTOs);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}

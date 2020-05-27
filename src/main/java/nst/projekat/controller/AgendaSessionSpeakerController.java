package nst.projekat.controller;

import nst.projekat.domain.AgendaSessionSpeakerPK;
import nst.projekat.domain.UserSessionPK;
import nst.projekat.dto.AgendaSessionSpeakerDTO;
import nst.projekat.dto.AgendaSessionTrackDTO;
import nst.projekat.service.AgendaSessionSpeakerService;
import nst.projekat.service.AgendaSessionTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "agendaSessionSpeaker")
@CrossOrigin
public class AgendaSessionSpeakerController {
    @Autowired
    private AgendaSessionSpeakerService agendaSessionSpeakerService;

    @RequestMapping(value = "saveAll", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity save(@RequestBody List<AgendaSessionSpeakerDTO> agendaSessionSpeakerDTOs) {
        try {
            for (AgendaSessionSpeakerDTO assDTO: agendaSessionSpeakerDTOs) {
                agendaSessionSpeakerService.save(assDTO);
            }
            return ResponseEntity.ok(agendaSessionSpeakerDTOs);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @RequestMapping(value = "all/{agendaID}-{sessionID}",method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity findAllBySession(@PathVariable Long agendaID, @PathVariable Long sessionID) {
        try {
            return ResponseEntity.ok(agendaSessionSpeakerService.findAllByAgendaAndSession(agendaID, sessionID));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "removeAll", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity delete(@RequestBody List<AgendaSessionSpeakerDTO> agendaSessionSpeakerDTOs) {
        try {
            for (AgendaSessionSpeakerDTO assDTO: agendaSessionSpeakerDTOs) {
                agendaSessionSpeakerService.delete(assDTO);
            }
            return ResponseEntity.ok(agendaSessionSpeakerDTOs);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "allBySpeaker/{speakerID}",method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity findAllBySpeakerGroupByAgenda(@PathVariable Long speakerID) {
        try {
            return ResponseEntity.ok(agendaSessionSpeakerService.findAllBySpeaker(speakerID));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "get/{agendaID}-{sessionID}-{speakerID}")
    public @ResponseBody
    ResponseEntity findById(@PathVariable Long agendaID, @PathVariable Long sessionID, @PathVariable Long speakerID) {
        try {
            AgendaSessionSpeakerPK sessionSpeakerPK = new AgendaSessionSpeakerPK(sessionID, agendaID, speakerID);
            return ResponseEntity.ok(agendaSessionSpeakerService.findById(sessionSpeakerPK));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id!");
        }
    }
}

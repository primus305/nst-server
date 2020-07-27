package nst.projekat.controller;

import nst.projekat.domain.AgendaSessionSpeakerPK;
import nst.projekat.service.AgendaSessionSpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "agendaSessionSpeaker")
@CrossOrigin
public class AgendaSessionSpeakerController {
    @Autowired
    private AgendaSessionSpeakerService agendaSessionSpeakerService;

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

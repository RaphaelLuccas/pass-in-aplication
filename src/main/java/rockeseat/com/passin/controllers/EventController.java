package rockeseat.com.passin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import rockeseat.com.passin.dto.attendee.AttendeeIdDTO;
import rockeseat.com.passin.dto.attendee.AttendeesListResponeDTO;
import rockeseat.com.passin.dto.event.EventIdDTO;
import rockeseat.com.passin.dto.event.EventRequestDTO;
import rockeseat.com.passin.dto.event.EventResponseDTO;
import rockeseat.com.passin.services.AttendeeService;
import rockeseat.com.passin.services.EventService;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final AttendeeService attendeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEvent(@PathVariable String id){
        EventResponseDTO event = this.eventService.getEventDetail(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping("/{eventId}/attendees")
    public ResponseEntity<AttendeeIdDTO> registerParticipant(@PathVariable String eventId, @RequestBody EventRequestDTO body, UriComponents uriComponentsBuilder){
        AttendeeIdDTO attendeeIdDTO = this.eventService.registerAttendeeOnEvent(eventId, body);

        var uri = uriComponentsBuilder.path("/attendees/{attendeedId}/badge").buildAndExpand(attendeeIdDTO.attendeeId()).toUri();

        return ResponseEntity.created(uri).body(attendeeIdDTO);
    }

    @GetMapping("/attendees/{id}")
    public ResponseEntity<AttendeesListResponeDTO> getEventAttendees(@PathVariable String id) {
        AttendeesListResponeDTO attendeesListRespone = this.attendeeService.getEventsAttendee(id);
        return ResponseEntity.ok(attendeesListRespone);
    }
}

package rockeseat.com.passin.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rockeseat.com.passin.domain.attendee.exceptions.AttendeeAlreadyExistException;
import rockeseat.com.passin.domain.attendee.exceptions.AttendeeNotFoundExecption;
import rockeseat.com.passin.domain.checkin.exceptions.CheckInAlreadyExistsException;
import rockeseat.com.passin.domain.event.exceptions.EventFullException;
import rockeseat.com.passin.domain.event.exceptions.EventNotFoundException;
import rockeseat.com.passin.dto.general.ErrorResponseDTO;

@ControllerAdvice
public class ExceptionEntityHandler {
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handleEventNotFound(EventNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(EventFullException.class)
    public ResponseEntity handleEventFull(EventFullException exception) {
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(exception.getMessage()));
    }

    @ExceptionHandler(AttendeeNotFoundExecption.class)
    public ResponseEntity<ErrorResponseDTO> handleAttendeeNotFound(AttendeeNotFoundExecption exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AttendeeAlreadyExistException.class)
    public ResponseEntity handleAttendeeAlreadyExists(AttendeeAlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(CheckInAlreadyExistsException.class)
    public ResponseEntity handleACheckInAlreadyExistis(CheckInAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
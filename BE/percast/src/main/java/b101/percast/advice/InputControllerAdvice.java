package b101.percast.advice;

import b101.percast.Exception.InputNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InputControllerAdvice {
    @ExceptionHandler(InputNotFoundException.class)
    public ResponseEntity<String> inputNotFoundHandle() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

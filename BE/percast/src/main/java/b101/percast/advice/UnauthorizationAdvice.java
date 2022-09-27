package b101.percast.advice;

import b101.percast.Exception.AdminUnauthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UnauthorizationAdvice {
    @ExceptionHandler(AdminUnauthorizationException.class)
    public ResponseEntity<String> noticeNotFoundHandler(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

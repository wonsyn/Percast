package b101.percast.advice;

import b101.percast.Exception.AnswerNotFoundException;
import b101.percast.Exception.NoParentQnaException;
import b101.percast.Exception.QnaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QnaControllerAdvice {

    @ExceptionHandler(QnaNotFoundException.class)
    public ResponseEntity<String> qnaNotFoundHandle() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ExceptionHandler(NoParentQnaException.class)
    public ResponseEntity<String> noParentQnaHandle() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(AnswerNotFoundException.class)
    public ResponseEntity<String> answerNotFoundHandle() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

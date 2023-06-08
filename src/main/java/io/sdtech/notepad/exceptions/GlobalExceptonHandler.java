package io.sdtech.notepad.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptonHandler {
    @ExceptionHandler(NoSuchNoteException.class)
    public ResponseEntity<?> handleNoSuchNoteException() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}

package br.com.videos.infra;

import br.com.videos.DTO.Validate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class Validations {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>validateFields(MethodArgumentNotValidException ex){
        var error = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream().map(Validate::new).toList());
    }
}

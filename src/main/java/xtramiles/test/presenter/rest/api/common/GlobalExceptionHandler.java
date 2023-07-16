package xtramiles.test.presenter.rest.api.common;

import xtramiles.test.core.domain.IdAlreadyUsedException;
import xtramiles.test.presenter.rest.api.entities.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {IdAlreadyUsedException.class})
    ResponseEntity<ApiResponse> handleIdAlreadyUsedException(IdAlreadyUsedException ex) {
        return ResponseEntity.badRequest().body(ApiResponse.from(false, ex.getMessage()));
    }    
}

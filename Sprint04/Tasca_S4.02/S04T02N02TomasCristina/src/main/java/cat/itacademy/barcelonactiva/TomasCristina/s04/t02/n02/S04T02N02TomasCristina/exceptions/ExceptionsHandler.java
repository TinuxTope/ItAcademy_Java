package cat.itacademy.barcelonactiva.TomasCristina.s04.t02.n02.S04T02N02TomasCristina.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(FruitNotFoundException.class)
    public ResponseEntity<String> FruiNotFound(FruitNotFoundException e, WebRequest request){
        String messatge = e.getMessage() + " " + request.getDescription(false);
        return new ResponseEntity<String>(messatge, HttpStatus.NOT_FOUND);
    }

}
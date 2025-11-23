package cl.duoc.ms_lab_assignment.infrastructure.exceptions;

import cl.duoc.ms_lab_assignment.infrastructure.dtos.wrapper.WrapperResponse;
import cl.duoc.ms_lab_assignment.domain.exceptions.EntityNotFoundException;
import cl.duoc.ms_lab_assignment.domain.exceptions.InvalidCredentialException;
import cl.duoc.ms_lab_assignment.domain.exceptions.UsernameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class RestControllerAdviceException {
    private final String statusError ="ERROR";
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public WrapperResponse<String> handleEntityNotFoundException (EntityNotFoundException exception){
        var response = new WrapperResponse<>(exception.getMessage());
        response.setStatus(statusError);
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public WrapperResponse<List<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
        return new WrapperResponse<>(errors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameException.class)
    public WrapperResponse<String> handleUsernameException(UsernameException exception) {
        var response = new WrapperResponse<>(exception.getMessage());
        response.setStatus(statusError);
        return response;
    }


    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(RuntimeException.class)
    public WrapperResponse<String> handleDefaultException(RuntimeException exception) {
        var response = new WrapperResponse<>(exception.getMessage());
        response.setStatus(statusError);
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public WrapperResponse<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        var response = new WrapperResponse<>(ex.getMessage());
        response.setStatus(statusError);
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentialException.class)
    public WrapperResponse<String> handleInvalidCredentialException(InvalidCredentialException ex) {
        var response = new WrapperResponse<>(ex.getMessage());
        response.setStatus(statusError);
        return response;
    }

}

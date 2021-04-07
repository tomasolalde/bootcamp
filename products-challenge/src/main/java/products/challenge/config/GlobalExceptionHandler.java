package products.challenge.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import products.challenge.exceptions.ApiError;
import products.challenge.exceptions.ApiException;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiError> noHandlerFoundException(HttpServletRequest req, NoHandlerFoundException e) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.name(), String.format("Ruta %s no encontrada", req.getRequestURI()), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(apiError.getStatus())
                .body(apiError);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ApiError> handleIOException(IOException e) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.name(), "Error interno en el servidor", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ApiError> hanldeFileNotFoundException(FileNotFoundException e) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.name(), "Archivo no encontrado", HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(value = {ApiException.class})
    protected ResponseEntity<ApiError> handleApiException(ApiException e) {
        Integer statusCode = e.getStatusCode();
        ApiError apiError = new ApiError(e.getCode(), e.getDescription(), statusCode);
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ApiError> handleUnknownException(Exception e) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.name(), "Error interno en el servidor", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }
}
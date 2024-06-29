package exception;

import com.project.smartfit.dto.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
/*Anotación para crear un controller que maneja exepciones
* de erros API*/
public class GlobalExeptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerGenericExeption(Exception exeption,
                                                    HttpServletRequest request){
            ApiError apiError = new ApiError();
            apiError.setBackengMessage(exeption.getLocalizedMessage());
            apiError.setUrl(request.getRequestURL().toString());
            apiError.setMethod(request.getMethod());
            apiError.setMethod("Error en el servidor");
            apiError.setTimestamp(LocalDateTime.now());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }
}

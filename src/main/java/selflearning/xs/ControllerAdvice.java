package selflearning.xs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import selflearning.xs.exceptions.UserIdNotExistException;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {
    @ExceptionHandler(UserIdNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResult handleUserIdNotExistException(UserIdNotExistException ex) {
        log.warn(ex.getMessage());
        final ErrorResult errorResult = new ErrorResult(ex.getErrorCode());
        errorResult.setMessage(ex.getUserId().toString());
        return errorResult;
    }
}

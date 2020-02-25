package selflearning.xs;

import lombok.NoArgsConstructor;
import selflearning.xs.exceptions.ErrorCode;

@NoArgsConstructor
public class ErrorResult {
    private String message;

    private String errorCode;

    public ErrorResult(ErrorCode errorCode) {
        this.errorCode = errorCode.getValue();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}

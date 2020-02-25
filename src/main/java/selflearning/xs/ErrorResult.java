package selflearning.xs;

import com.fasterxml.jackson.annotation.JsonProperty;
import selflearning.xs.exceptions.ErrorCode;

public class ErrorResult {
    private String message;

    @JsonProperty("error_code")
    private String errorCode;

    public ErrorResult(ErrorCode errorCode, String message) {
        this.message = message;
        this.errorCode = errorCode.getValue();
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

package selflearning.xs.exceptions;

public class UserIdNotExistException extends RuntimeException {
    private static final long serialVersionUID = 4328743L;
    private static final ErrorCode errorCode = ErrorCode.USER_ID_NOT_EXIST;
    private Long userId;

    public UserIdNotExistException(String message, Long id) {
        super(message);
        userId = id;
    }

    public Long getUserId() {
        return userId;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}

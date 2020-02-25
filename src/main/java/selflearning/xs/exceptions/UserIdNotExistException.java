package selflearning.xs.exceptions;

public class UserIdNotExistException extends RuntimeException {

    private Long userId;

    public UserIdNotExistException(String message, Long id) {
        super(message);
        userId = id;
    }

    public Long getUserId() {
        return userId;
    }
}

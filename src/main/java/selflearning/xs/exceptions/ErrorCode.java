package selflearning.xs.exceptions;

public enum ErrorCode {
    USER_ID_NOT_EXIST("user_id_not_exist");

    private String value;

    ErrorCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

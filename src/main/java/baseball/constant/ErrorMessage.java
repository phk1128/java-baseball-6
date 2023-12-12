package baseball.constant;

public enum ErrorMessage {

    INVALID_NUMBER("각 숫자는 1~9사이의 자연수만 가능 합니다."),
    INVALID_NUMBER_SIZE("숫자는 3자리여야 합니다."),
    DUPLICATE_NUMBER("숫자는 중복될 수 없습니다."),
    INVALID_COMMAND("1과 2만 입력 가능합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}

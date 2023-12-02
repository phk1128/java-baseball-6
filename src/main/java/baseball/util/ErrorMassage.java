package baseball.util;

public enum ErrorMassage {

    INVALID_INPUT("유효하지 않은 입력입니다.");


    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMassage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}

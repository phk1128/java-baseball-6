package baseball.domain;

import static baseball.constant.ErrorMessage.DUPLICATE_NUMBER;
import static baseball.constant.ErrorMessage.INVALID_NUMBER;
import static baseball.constant.ErrorMessage.INVALID_NUMBER_SIZE;

import java.util.List;

public class UserNumber {

    private static final int NUMBER_SIZE = 3;
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 9;

    private final List<Integer> numbers;

    private UserNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static UserNumber create(List<Integer> inputNumber) {
        validateSize(inputNumber);
        validateRange(inputNumber);
        validateDuplicate(inputNumber);
        return new UserNumber(inputNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static void validateDuplicate(List<Integer> inputNumber) {
        if (isDuplicate(inputNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    private static boolean isDuplicate(List<Integer> inputNumber) {
        return inputNumber.stream()
                .distinct()
                .count() != inputNumber.size();
    }

    private static void validateRange(List<Integer> inputNumber) {
        if (isWrongRange(inputNumber)) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }

    private static boolean isWrongRange(List<Integer> inputNumber) {
        return inputNumber.stream()
                .anyMatch(num -> num < MINIMUM || num > MAXIMUM);
    }

    private static void validateSize(List<Integer> inputNumber) {
        if (isWrongSize(inputNumber)) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE.getMessage());
        }
    }

    private static boolean isWrongSize(List<Integer> inputNumber) {
        return inputNumber.size() != NUMBER_SIZE;
    }
}

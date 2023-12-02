package baseball.domain;

import static baseball.util.ErrorMassage.INVALID_INPUT;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class UserNumbers {

    private static final int INPUT_LENGTH = 3;
    private static final Pattern INPUT_FORMAT = Pattern.compile("[1-9\\s]+$");
    private final List<Integer> numbers;

    private UserNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static UserNumbers create(String input) {
        input = removeSpace(input);
        validateInput(input);
        return new UserNumbers(convertStringToList(input));
    }

    private static void validateInput(String number) {
        validateFormat(number);
        validateLength(number);
        validateDuplicate(number);

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static void validateDuplicate(String input) {
        if (isDuplicate(input)) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private static void validateLength(String input) {
        if (isWrongLength(input)) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private static void validateFormat(String input) {
        if (isWrongFormat(input)) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private static boolean isWrongFormat(String input) {
        return !INPUT_FORMAT
                .matcher(input)
                .matches();
    }

    private static boolean isWrongLength(String input) {
        return input.length() != INPUT_LENGTH;
    }

    private static boolean isDuplicate(String input) {
        return Arrays.stream(input.split(""))
                .distinct()
                .count() != input.length();
    }

    private static List<Integer> convertStringToList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    private static String removeSpace(String input) {
        return input.replace(" ", "");
    }
}

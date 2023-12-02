package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {

    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 9;
    private final List<Integer> numbers;

    private ComputerNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static ComputerNumbers create() {
        return new ComputerNumbers(randomNumbersGenerator());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static List<Integer> randomNumbersGenerator() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            addRandomNumber(randomNumbers);
        }
        return randomNumbers;
    }

    private static void addRandomNumber(List<Integer> randomNumbers) {
        int randomNumber = Randoms.pickNumberInRange(MINIMUM, MAXIMUM);
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }
}

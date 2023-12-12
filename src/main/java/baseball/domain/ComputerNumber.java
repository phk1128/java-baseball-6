package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private final List<Integer> numbers;

    private ComputerNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static ComputerNumber create() {
        return new ComputerNumber(generateNumbers());
    }

    private static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        addRandomNumber(numbers);
        return numbers;
    }

    private static void addRandomNumber(List<Integer> numbers) {
        if (numbers.size() == 3) {
            return;
        }
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        numbers.add(randomNumber);
        addRandomNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}

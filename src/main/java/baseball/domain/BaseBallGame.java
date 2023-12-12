package baseball.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class BaseBallGame {

    private int ball;
    private int strike;

    private final List<Integer> computerNumber;

    private BaseBallGame(List<Integer> computerNumber) {

        this.computerNumber = computerNumber;
    }

    public static BaseBallGame create(ComputerNumber computerNumber) {
        return new BaseBallGame(computerNumber.getNumbers());
    }

    public void calculateScore(UserNumber userNumber) {
        calculateBall(userNumber);
        calculateStrike(userNumber);
    }

    private void calculateBall(UserNumber userNumber) {
        List<Integer> userNumbers = userNumber.getNumbers();
        this.ball = (int) Stream.iterate(0, i -> i + 1).limit(userNumbers.size())
                .filter(i -> this.computerNumber.contains(userNumbers.get(i)))
                .filter(i -> !Objects.equals(this.computerNumber.get(i), userNumbers.get(i)))
                .count();
    }

    private void calculateStrike(UserNumber userNumber) {
        List<Integer> userNumbers = userNumber.getNumbers();
        this.strike = (int) Stream.iterate(0, i -> i + 1).limit(userNumbers.size())
                .filter(i -> Objects.equals(this.computerNumber.get(i), userNumbers.get(i)))
                .count();
    }

    public boolean isAllStrike() {
        return Objects.equals(computerNumber.size(), strike);
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}

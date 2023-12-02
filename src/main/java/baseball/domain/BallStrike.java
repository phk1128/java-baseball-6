package baseball.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class BallStrike {

    private final int ball;
    private final int strike;

    private BallStrike(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static BallStrike create(UserNumbers userNumbers, ComputerNumbers computerNumbers) {
        List<Integer> user = userNumbers.getNumbers();
        List<Integer> computer = computerNumbers.getNumbers();
        int ball = countBall(user, computer);
        int strike = countStrike(user, computer);
        return new BallStrike(ball, strike);
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    private static int countBall(List<Integer> userNumbers, List<Integer> computerNumbers) {
        return (int) Stream.iterate(0, i -> i + 1).limit(userNumbers.size())
                .filter(i -> !Objects.equals(userNumbers.get(i), computerNumbers.get(i)))
                .filter(i -> computerNumbers.contains(userNumbers.get(i)))
                .count();
    }

    private static int countStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        return (int) Stream.iterate(0, i -> i + 1).limit(userNumbers.size())
                .filter(i -> Objects.equals(userNumbers.get(i), computerNumbers.get(i)))
                .count();
    }


}

package baseball.service;

import baseball.domain.BallStrike;
import baseball.domain.ComputerNumbers;
import baseball.domain.UserNumbers;

public class BaseballService {

    public ComputerNumbers createComputerNumbers() {
        return ComputerNumbers.create();
    }

    public UserNumbers createUserNumbers(String input) {
        return UserNumbers.create(input);
    }

    public BallStrike createBallStrike(UserNumbers userNumbers, ComputerNumbers computerNumbers) {
        return BallStrike.create(userNumbers, computerNumbers);
    }
}

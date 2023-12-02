package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallStrikeTest {

    @DisplayName("볼-스트라이크 개수 확인")
    @Test
    void checkBallAndStrike() throws Exception {
        //given
        String input = "123";
        //when
        ComputerNumbers computerNumbers = ComputerNumbers.create();
        UserNumbers userNumbers = UserNumbers.create(input);
        BallStrike ballStrike = BallStrike.create(userNumbers, computerNumbers);
        //then
        System.out.println(computerNumbers.getNumbers());
        System.out.println(ballStrike.getBall() + " " + ballStrike.getStrike());
    }

}
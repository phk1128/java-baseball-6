package baseball.dto;

import baseball.domain.BallStrike;

public record BallStrikeDto(int ball, int strike) {

    public static BallStrikeDto from(BallStrike ballStrike) {
        return new BallStrikeDto(ballStrike.getBall(), ballStrike.getStrike());
    }
}

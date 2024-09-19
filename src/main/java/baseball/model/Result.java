package baseball.model;

import baseball.constant.BaseBallConstant;

public class Result {

	private final PlayerNumber playerNumber;
	private final ComputerNumber computerNumber;

	public Result(final PlayerNumber playerNumber, final ComputerNumber computerNumber) {
		this.playerNumber = playerNumber;
		this.computerNumber = computerNumber;
	}

	public int getBall() {
		int ball = 0;
		for (int idx = 0; idx < BaseBallConstant.MAX_SIZE; idx++) {
			final int number = playerNumber.getNumber(idx);
			if (computerNumber.isContains(number) && !computerNumber.isMatch(number, idx)) {
				ball++;
			}
		}
		return ball;
	}

	public int getStrike() {
		int strike = 0;
		for (int idx = 0; idx < BaseBallConstant.MAX_SIZE; idx++) {
			final int number = playerNumber.getNumber(idx);
			if (computerNumber.isContains(number) && computerNumber.isMatch(number, idx)) {
				strike++;
			}
		}
		return strike;
	}
}

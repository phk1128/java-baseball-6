package baseball.service;

import java.util.List;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.model.Result;
import baseball.util.NumbersGenerator;
import baseball.util.NumbersValidator;

public class BaseBallService {

	private final NumbersGenerator numbersGenerator;
	private final NumbersValidator numbersValidator;

	public BaseBallService(final NumbersGenerator numbersGenerator, final NumbersValidator numbersValidator) {
		this.numbersGenerator = numbersGenerator;
		this.numbersValidator = numbersValidator;
	}

	public ComputerNumber getComputerNumber() {
		return new ComputerNumber(numbersGenerator);
	}

	public PlayerNumber getPlayerNumber(final List<Integer> inputNumbers) {
		return new PlayerNumber(inputNumbers, numbersValidator);
	}

	public Result getResult(final PlayerNumber playerNumber, final ComputerNumber computerNumber) {
		return new Result(playerNumber, computerNumber);
	}

}

package baseball.model;

import java.util.List;

import baseball.util.NumbersValidator;

public class PlayerNumber {

	private final List<Integer> numbers;

	public PlayerNumber(final List<Integer> numbers, final NumbersValidator numbersValidator) {
		this.numbers = numbers;
		numbersValidator.validateSize(numbers);
		numbersValidator.validateDuplicate(numbers);
		numbersValidator.validateRange(numbers);
	}

	public int getNumber(final int idx) {
		return numbers.get(idx);
	}

}

package baseball.model;

import java.util.List;

import baseball.util.NumbersGenerator;

public class ComputerNumber {

	private final List<Integer> numbers;

	public ComputerNumber(final NumbersGenerator numbersGenerator) {
		this.numbers = numbersGenerator.generateNumbers();
	}

	public boolean isContains(final int number) {
		return numbers.contains(number);
	}

	public boolean isMatch(final int number, final int idx) {
		return numbers.get(idx) == number;
	}

}

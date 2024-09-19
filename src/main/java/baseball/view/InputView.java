package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public String readInput() {
		final String input = Console.readLine();
		InputValidator.validateInput(input);
		return input;
	}
}

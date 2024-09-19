package baseball.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

	private static final Pattern pattern = Pattern.compile("\\d+");

	private InputValidator() {
	}

	public static void validateInput(String input) {
		final Matcher matcher = pattern.matcher(input);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("입력값은 숫자만 가능합니다.");
		}
	}
}

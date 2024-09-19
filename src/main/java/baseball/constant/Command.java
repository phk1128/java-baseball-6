package baseball.constant;

import java.util.Arrays;

public enum Command {

	RESTART(BaseBallConstant.RESTART),
	EXIT(BaseBallConstant.EXIT),
	;

	private final String input;

	Command(final String input) {
		this.input = input;
	}

	public static Command findByInput(final String input) {
		return Arrays.stream(Command.values())
			.filter(command -> command.input.equals(input))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않은 명령어 입니다."));

	}

}

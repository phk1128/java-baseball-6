package baseball.util;

import java.util.List;

import baseball.constant.BaseBallConstant;

public class PlayerNumbersValidator implements NumbersValidator {

	@Override
	public void validateSize(final List<Integer> numbers) {
		if (numbers.size() > BaseBallConstant.MAX_SIZE) {
			throw new IllegalArgumentException("숫자 사이즈 초과");
		}
	}

	@Override
	public void validateDuplicate(final List<Integer> numbers) {
		final long count = numbers.stream()
			.distinct()
			.count();
		if (count < BaseBallConstant.MAX_SIZE) {
			throw new IllegalArgumentException("숫자 중복");
		}
	}

	@Override
	public void validateRange(final List<Integer> numbers) {
		if (numbers.stream().anyMatch(this::isWrongRange)) {
			throw new IllegalArgumentException("잘못된 숫자 범위");
		}

	}

	private boolean isWrongRange(final int number) {
		return number < BaseBallConstant.MIN_RANGE ||
			number > BaseBallConstant.MAX_RANGE;
	}
}

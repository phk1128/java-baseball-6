package baseball.util;

import java.util.List;

public interface NumbersValidator {

	void validateSize(List<Integer> numbers);

	void validateDuplicate(List<Integer> numbers);

	void validateRange(List<Integer> numbers);

}

package baseball.util;

import java.util.ArrayList;
import java.util.List;

import baseball.constant.BaseBallConstant;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbersGenerator implements NumbersGenerator {

	@Override
	public List<Integer> generateNumbers() {
		List<Integer> numbers = new ArrayList<>();
		while (numbers.size() < BaseBallConstant.MAX_SIZE) {
			final int randomNumber = Randoms.pickNumberInRange(BaseBallConstant.MIN_RANGE, BaseBallConstant.MAX_RANGE);
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
			}
		}
		return numbers;
	}

}

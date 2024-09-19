package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.util.NumbersGenerator;

class ComputerNumberTest {

	@Test
	@DisplayName("랜덤 숫자 생성 테스트")
	void randomNumbersTest() throws Exception {
		//given
		final MockRandomNumbersGenerator mockRandomNumbersGenerator = new MockRandomNumbersGenerator();
		final ComputerNumber computerNumber = new ComputerNumber(mockRandomNumbersGenerator);

		//when
		final boolean contains = computerNumber.isContains(1);
		final boolean match = computerNumber.isMatch(1, 0);
		//then
		assertAll(
			() -> assertThat(contains).isTrue(),
			() -> assertThat(match).isTrue()
		);

	}

	static class MockRandomNumbersGenerator implements NumbersGenerator {

		@Override
		public List<Integer> generateNumbers() {
			return List.of(1, 1, 1);
		}
	}
}
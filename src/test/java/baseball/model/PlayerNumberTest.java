package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.util.PlayerNumbersValidator;

class PlayerNumberTest {

	@Test
	@DisplayName("유효성 테스트1")
	void validateTest1() throws Exception {
		//given
		final List<Integer> list1 = List.of(10, 2, 3);
		final List<Integer> list2 = List.of(1, 1, 1);
		final PlayerNumbersValidator playerNumbersValidator = new PlayerNumbersValidator();

		//when
		//then
		assertAll(
			() -> assertThatThrownBy(() -> new PlayerNumber(list1, playerNumbersValidator)).isInstanceOf(
				IllegalArgumentException.class),
			() -> assertThatThrownBy(() -> new PlayerNumber(list2, playerNumbersValidator)).isInstanceOf(
				IllegalArgumentException.class)
		);

	}

}
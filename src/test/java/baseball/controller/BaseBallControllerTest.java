package baseball.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

class BaseBallControllerTest extends NsTest {

	@Test
	@DisplayName("예외 테스트1")
	void 예외_테스트1() throws Exception {
		//given
		assertSimpleTest(() -> {
			runException("1j");
			assertThat(output()).contains("숫자");

		});

		//when

		//then

	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
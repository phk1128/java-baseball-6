package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserNumbersTest {

    @DisplayName("유효하지 않은 입력으로 예외가 발생한다.")
    @ValueSource(strings = {"012", " 12", "aaa", "12", "1234"})
    @ParameterizedTest
    void validateInput(String input) throws Exception {
        //given
        //when
        //then

        assertThatThrownBy(() -> UserNumbers.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}
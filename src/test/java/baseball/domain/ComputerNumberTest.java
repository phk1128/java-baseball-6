package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerNumberTest {

    @DisplayName("서로 다른 숫자 3개를 생성한다.")
    @Test
    void createComputerNumberTest() throws Exception {
        //given
        ComputerNumber computerNumber = ComputerNumber.create();
        //when
        //then
        System.out.println(computerNumber.getNumbers());
    }

}
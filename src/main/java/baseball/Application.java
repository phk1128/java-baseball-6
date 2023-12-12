package baseball;

import baseball.controller.BaseBallController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {

        BaseBallController baseBallController = new BaseBallController(
                new InputView(),
                new OutputView()
        );
        baseBallController.run();
        // TODO: 프로그램 구현
    }
}

package baseball;

import baseball.controller.BaseBallController;
import baseball.service.BaseBallService;
import baseball.util.PlayerNumbersValidator;
import baseball.util.RandomNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
	public static void main(String[] args) {

		final BaseBallService baseBallService = new BaseBallService(
			new RandomNumbersGenerator(),
			new PlayerNumbersValidator()
		);
		final InputView inputView = new InputView();
		final OutputView outputView = new OutputView();
		final BaseBallController baseBallController = new BaseBallController(
			baseBallService,
			inputView,
			outputView
		);

		baseBallController.run();
	}
}

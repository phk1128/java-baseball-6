package baseball.controller;

import static baseball.constant.BaseBallConstant.*;
import static baseball.util.LoopTemplate.*;

import java.util.Arrays;
import java.util.List;

import baseball.constant.Command;
import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.model.Result;
import baseball.service.BaseBallService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {

	private final BaseBallService baseBallService;
	private final InputView inputView;
	private final OutputView outputView;

	private int ball;
	private int strike;

	public BaseBallController(final BaseBallService baseBallService, final InputView inputView,
		final OutputView outputView) {
		this.baseBallService = baseBallService;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		do {
			outputView.printIntro();
			start();
		} while (isRetry());
	}

	private void start() {
		final ComputerNumber computerNumber = baseBallService.getComputerNumber();
		do {
			final PlayerNumber playerNumber = requestPlayerNumbers();
			final Result result = baseBallService.getResult(playerNumber, computerNumber);
			ball = result.getBall();
			strike = result.getStrike();

			responseScore();
		} while (!isAllStrike());
	}

	private void responseScore() {
		if (ball != 0 && strike == 0) {
			outputView.printBallScore(ball);
		}
		if (ball != 0 && strike != 0) {
			outputView.printBallAndStrikeScore(ball, strike);
		}
		if (ball == 0 && strike != 0) {
			outputView.printStrikeScore(strike);
		}
		if (ball == 0 && strike == 0) {
			outputView.printNothing();
		}
	}

	private PlayerNumber requestPlayerNumbers() {
		return tryCatchTemplate(() -> {
			outputView.printEnd();
			outputView.printAskPlayerNumber();
			final String input = inputView.readInput();
			final List<Integer> inputNumbers = Arrays.stream(input.split("")).map(Integer::parseInt).toList();
			return baseBallService.getPlayerNumber(inputNumbers);
		});
	}

	private boolean isRetry() {
		return tryCatchTemplate(() -> {
			outputView.printAskCommand();
			final String input = inputView.readInput();
			final Command command = Command.findByInput(input);
			return command.equals(Command.RESTART);
		});
	}

	private boolean isAllStrike() {
		return strike == MAX_SIZE;
	}
}

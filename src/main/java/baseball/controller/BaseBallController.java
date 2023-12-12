package baseball.controller;

import baseball.constant.ErrorMessage;
import baseball.constant.GameCommand;
import baseball.domain.BaseBallGame;
import baseball.domain.ComputerNumber;
import baseball.domain.UserNumber;
import baseball.util.LoopTemplate;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BaseBallController {

    private final InputView inputView;
    private final OutputView outputView;

    public BaseBallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        do {
            outputView.printIntro();
            start();
        } while (isRetry());
    }

    public void start() {
        ComputerNumber computerNumber = ComputerNumber.create();
        BaseBallGame baseBallGame = BaseBallGame.create(computerNumber);
        do {
            UserNumber userNumber = requestUserNumber();
            baseBallGame.calculateScore(userNumber);
            responseScore(baseBallGame);
        } while (!baseBallGame.isAllStrike());

    }

    private void responseScore(BaseBallGame baseBallGame) {
        int ball = baseBallGame.getBall();
        int strike = baseBallGame.getStrike();
        if (ball != 0 && strike == 0) {
            outputView.printBall(ball);
        }
        if (ball != 0 && strike != 0) {
            outputView.printBallAndStrike(ball, strike);
        }
        if (ball == 0 && strike != 0) {
            outputView.printStrike(strike);
        }
        if (ball == 0 && strike == 0) {
            outputView.printNothing();
        }
    }

    private boolean isRetry() {
        outputView.printEnd();
        GameCommand gameCommand = requestGameCommand();
        return Objects.equals(gameCommand, GameCommand.RETRY);
    }

    private GameCommand requestGameCommand() {
        return LoopTemplate.tryCatchTemplate(() -> {
            outputView.printAskCommand();
            String input = inputView.readInput();
            return GameCommand.findByCommand(input);
        });
    }

    private UserNumber requestUserNumber() {
        return LoopTemplate.tryCatchTemplate(() -> {
            outputView.printAskUserNumber();
            String input = inputView.readInput();
            List<Integer> convertedInput = convertToIntegerList(convertStringToList(input));
            return UserNumber.create(convertedInput);
        });
    }

    private List<String> convertStringToList(String str) {
        return Arrays.stream(str.split("")).toList();
    }

    private List<Integer> convertToIntegerList(List<String> strList) {
        return strList.stream()
                .map(this::convertStringToInt)
                .toList();
    }

    private int convertStringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }
}

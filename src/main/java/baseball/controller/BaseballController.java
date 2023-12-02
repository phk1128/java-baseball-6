package baseball.controller;

import static baseball.util.ErrorMassage.INVALID_INPUT;

import baseball.domain.BallStrike;
import baseball.domain.ComputerNumbers;
import baseball.domain.UserNumbers;
import baseball.dto.BallStrikeDto;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballService baseballService;

    public BaseballController(
            InputView inputView,
            OutputView outputView,
            BaseballService baseballService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballService = baseballService;
    }

    public void run() {
        outputView.printIntro();
        do {
            start();
        } while (isRestart());
    }

    public void start() {
        ComputerNumbers computerNumbers = baseballService.createComputerNumbers();
        int strike;
        do {
            outputView.printAskNumberMessage();
            String inputUserNumbers = inputView.readInput();
            UserNumbers userNumbers = baseballService.createUserNumbers(inputUserNumbers);
            BallStrike ballStrike = baseballService.createBallStrike(userNumbers, computerNumbers);
            BallStrikeDto ballStrikeDto = BallStrikeDto.from(ballStrike);
            strike = ballStrikeDto.strike();
            outputView.printBallStrike(ballStrikeDto);
        } while (isFinish(strike));
    }

    private boolean isFinish(int strike) {
        return strike != 3;
    }

    private boolean isRestart() {
        outputView.printEndMessage();
        outputView.printAskRestart();
        String input = inputView.readInput();
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException(INVALID_INPUT.getMessage());
    }
}

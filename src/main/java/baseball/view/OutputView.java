package baseball.view;

import baseball.dto.BallStrikeDto;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String INTRO = "숫자 야구 게임을 시작합니다.";
    private static final String ASK_NUMBER = "숫자를 입력해주세요 : ";
    private static final String BALL_AND_STRIKE = "%d볼 %d스트라이크";
    private static final String BALL = "%d볼";
    private static final String STRIKE = "%d스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public void printIntro() {
        System.out.println(INTRO);
    }

    public void printAskNumberMessage() {
        System.out.print(ASK_NUMBER);
    }

    public void printBallStrike(BallStrikeDto ballStrikeDto) {
        int ball = ballStrikeDto.ball();
        int strike = ballStrikeDto.strike();
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING);
        }
        if (ball != 0 && strike == 0) {
            System.out.println(String.format(BALL, ball));
        }
        if (ball == 0 && strike != 0) {
            System.out.println(String.format(STRIKE, strike));
        }
        if (ball != 0 && strike != 0) {
            System.out.println(String.format(BALL_AND_STRIKE, ball, strike));
        }
    }

    public void printEndMessage() {
        System.out.println(END);
    }

    public void printAskRestart() {
        System.out.println(ASK_RESTART);
    }

}

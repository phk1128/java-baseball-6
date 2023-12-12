package baseball.view;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String INTRO = "숫자 야구 게임을 시작합니다.";
    private static final String ASK_USER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String BALL_SCORE = "%d볼";
    private static final String STRIKE_SCORE = "%d스트라이크";
    private static final String BALL_STRIKE_SCORE = "%d볼 %d스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_COMMAND = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printIntro() {
        System.out.println(INTRO);
    }

    public void printAskUserNumber() {
        System.out.print(ASK_USER_NUMBER);
    }

    public void printBall(int ball) {
        System.out.println(String.format(BALL_SCORE, ball));
    }

    public void printStrike(int strike) {
        System.out.println(String.format(STRIKE_SCORE, strike));
    }

    public void printBallAndStrike(int ball, int strike) {
        System.out.println(String.format(BALL_STRIKE_SCORE, ball, strike));
    }

    public void printNothing() {
        System.out.println(NOTHING);
    }

    public void printEnd() {
        System.out.println(END);
    }

    public void printAskCommand() {
        System.out.println(ASK_COMMAND);
    }
}


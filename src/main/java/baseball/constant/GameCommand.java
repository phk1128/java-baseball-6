package baseball.constant;

import java.util.Arrays;
import java.util.Objects;

public enum GameCommand {

    RETRY("새로시작", "1"),
    QUIT("종료", "2");

    private final String name;
    private final String command;

    GameCommand(String name, String command) {
        this.name = name;
        this.command = command;
    }

    public static GameCommand findByCommand(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> Objects.equals(command, gameCommand.getCommand()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.getMessage()));
    }

    public String getCommand() {
        return command;
    }
}

package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {
    private static final String VALIDATE_HEIGHT = "높이는 1이상이어야 합니다.";
    private static final String VALIDATE_COUNT_PERSON = "참여자는 2명 이상이어야 합니다.";
    private static final int MIN_HEIGHT = 1;
    private static final int MIN_PERSON = 2;

    public static Ladder createLadder(int height, int countOfPerson) {
        validateLadder(height, countOfPerson);
        List<Line> lines = initLines(height, countOfPerson);
        return new Ladder(lines);
    }

    public static Ladder createLadderWithCustomLines(List<Line> customLines) {
        return new Ladder(customLines);
    }

    private static List<Line> initLines(int height, int countOfPerson) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.create(countOfPerson));
        }
        return lines;
    }

    private static void validateLadder(int height, int countOfPerson) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(VALIDATE_HEIGHT);
        }
        if (countOfPerson < MIN_PERSON) {
            throw new IllegalArgumentException(VALIDATE_COUNT_PERSON);
        }
    }
}

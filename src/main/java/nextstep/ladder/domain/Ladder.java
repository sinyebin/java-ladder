package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;


    public Ladder(List<Line> lines) {
        this.lines = lines;
    }


    private static List<Line> initLines(int height, int countOfPerson) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.create(countOfPerson));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        StringBuilder ladderOutput = new StringBuilder();
        for (Line line : lines) {
            ladderOutput.append(line.toString()).append("\n");
        }
        return ladderOutput.toString();
    }
}

package nextstep.model;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;
    private final int countOfPerson;

    public Lines(int vertical, int countOfPerson) {
        this.countOfPerson = countOfPerson;
        this.lines = new ArrayList<>();
        for (int i = 0; i < vertical; i++) {
            this.lines.add(new Line(countOfPerson));
        }
    }

    public void mark(int targetVertical, int targetHorizon) {
        this.lines.get(targetVertical).markOne(targetHorizon);
    }

    public String lineString(int targetVertical) {
        return this.lines.get(targetVertical).lineString();
    }

    public void initMark() {
        this.lines.get(0).markRandom();
    }

    public void markWithoutFirst() {
        for (int i = 1; i < this.lines.size(); i++) {
            Line top = this.lines.get(i - 1);
            this.lines.get(i).markRandom(top);
        }
    }
}

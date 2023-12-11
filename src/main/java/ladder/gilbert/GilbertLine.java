package ladder.gilbert;

import java.util.*;
import java.util.stream.Collectors;

import ladder.engine.Line;
import ladder.gilbert.domain.data.Direction;
import ladder.gilbert.domain.data.Point;

import static ladder.engine.Ladder.INDENT;
import static ladder.gilbert.domain.data.Name.NAME_SIZE;

public class GilbertLine implements Line {


    private final List<Point> points;

    public GilbertLine(String strings) {
        this(Arrays.stream(strings.split(""))
            .map(Direction::valueOfCharacter)
            .map(Point::new)
            .collect(Collectors.toList())
        );
    }

    public GilbertLine(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    @Override
    public int run(int index) {
        int leftIndex = 2 * index - 1;
        int rightIndex = 2 * index + 1;
        if (leftIndex >= 1) {
            index = toLeft(index, leftIndex);
        }
        if (rightIndex < points.size()) {
            index = toRight(index, rightIndex);
        }
        return index;
    }

    private int toLeft(int index, int leftIndex) {
        if (points.get(leftIndex).equalsHorizontal()) {
            index -= 1;
        }
        return index;
    }

    private int toRight(int index, int rightIndex) {
        if (points.get(rightIndex).equalsHorizontal()) {
            index += 1;
        }
        return index;
    }

    @Override
    public String toString() {
        return INDENT.repeat(NAME_SIZE) + points.stream()
            .map(Point::formatted)
            .collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        GilbertLine line = (GilbertLine) object;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return points != null ? points.hashCode() : 0;
    }

}
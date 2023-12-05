package ladder.domain.generator;

import ladder.domain.ladder.LadderColumn;
import ladder.domain.ladder.LadderConnection;
import ladder.domain.ladder.LadderLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 랜덤으로 구성되는 사다리 라인 한 개를 만듭니다.
 */
public class RandomLadderLineGenerator implements Generator<LadderLine> {
    private static final Random RANDOM = new Random();

    private final int theNumberOfColumn;

    /**
     * 랜덤으로 사다리 라인을 생성하는 생성기를 만듭니다.
     *
     * @param theNumberOfColumn 이 생성기가 생성할 LadderLine의 컬럼 수
     */
    public RandomLadderLineGenerator(int theNumberOfColumn) {
        this.theNumberOfColumn = theNumberOfColumn;
    }


    @Override
    public LadderLine make() {
        return generateRandomLine(theNumberOfColumn);
    }

    /**
     * 주어진 컬럼 수를 가지는 사다리 라인을 랜덤으로 하나 만듭니다.
     *
     * @param theNumberOfColumn 컬럼 수
     *
     * @return 랜덤 사다리 라인
     */
    private static LadderLine generateRandomLine(int theNumberOfColumn) {
        if (theNumberOfColumn <= 0) {
            throw new IllegalArgumentException("컬럼을 1개 미만으로 지정할 수 없으나 " + theNumberOfColumn + "개로 지정되어 호출되었습니다.");
        }

        List<LadderColumn> columns = new ArrayList<>();
        for (int columnIndex = 0; columnIndex < theNumberOfColumn-1; columnIndex++) {
            columnIndex = tryConnect(columnIndex, columns);
        }

        if (columns.size() < theNumberOfColumn) {
            columns.add(new LadderColumn(theNumberOfColumn-1, LadderConnection.NONE));
        }

        return new LadderLine(columns);
    }

    private static int tryConnect(int columnIndex, List<LadderColumn> columns) {
        if (RANDOM.nextBoolean() == false) {
            // 미연결
            LadderColumn column = new LadderColumn(columnIndex, LadderConnection.NONE);
            columns.add(column);
            return columnIndex;
        }

        // 연결
        LadderColumn column = new LadderColumn(columnIndex, LadderConnection.RIGHT);
        LadderColumn nextColumn = new LadderColumn(columnIndex +1, LadderConnection.LEFT);
        columns.add(column);
        columns.add(nextColumn);
        return columnIndex + 1;
    }
}
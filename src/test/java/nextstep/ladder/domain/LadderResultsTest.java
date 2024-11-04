package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultsTest {
    @DisplayName("결과 입력")
    @Test
    void 결과입력() {
        LadderResults ladderResults = new LadderResults("꽝,5000,꽝,3000");
        assertThat(ladderResults.getResults()).hasSize(4);

    }
}

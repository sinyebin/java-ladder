package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.Row;
import me.namuhuchutong.ladder.domain.factory.ScaffoldFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static me.namuhuchutong.ladder.domain.wrapper.LadderExpressionEnum.*;
import static org.assertj.core.api.Assertions.*;

class RowTest {

    @DisplayName("|--|--| 모양으로 연속된 사다리는 허용하지 않는다.")
    @Test
    void scaffold_should_not_be_continuous() {
        // given
        ScaffoldFactory testFactory = () -> HYPHEN;

        //when, then
        assertThatThrownBy(() -> Row.from(5, testFactory))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
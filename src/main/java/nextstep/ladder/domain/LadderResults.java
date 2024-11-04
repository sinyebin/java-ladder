package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {
    private final List<LadderResult> results;

    public LadderResults(String results) {
        this.results = Arrays.stream(results.split(","))
                .map(String::trim)
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }

    public List<LadderResult> getResults() {
        return results;
    }
}

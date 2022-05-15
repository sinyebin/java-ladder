package nextstep.ladder;

import nextstep.ladder.domain.MaxHeightOfLadder;
import nextstep.ladder.domain.Members;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {
    public static void main(String[] args) {
        Members members = InputView.inputMemberNames();
        MaxHeightOfLadder maxHeightOfLadder = InputView.inputMaxHeightOfLadder();

        System.out.println("members = " + members);
        System.out.println("maxHeightOfLadder = " + maxHeightOfLadder);
        OutputView.outputLadder(members, maxHeightOfLadder);
    }
}

package nextstep.ladder;

import static nextstep.ladder.view.InputView.inputLadderHeight;
import static nextstep.ladder.view.InputView.inputNames;
import static nextstep.ladder.view.ResultView.printLadder;
import static nextstep.ladder.view.ResultView.printPlayerNames;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderFactory;
import nextstep.ladder.domain.Players;

public class Application {
    public static void main(String[] args) {
        Players players = new Players(inputNames());
        int height = inputLadderHeight();

        Ladder ladder = LadderFactory.createLadder(height, players.getPlayerCount());

        printPlayerNames(players);

        printLadder(ladder);
    }
}

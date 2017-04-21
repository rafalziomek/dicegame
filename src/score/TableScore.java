package score;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import diceModel.DiceResult;
import player.Player;
import strategies.Strategy;
import strategies.StrategyType;


public class TableScore {
	private List<PlayerScore> playerScores;
	public TableScore(Player[] players) {
		playerScores = new ArrayList<PlayerScore>();
		Arrays.stream(players).forEach(p -> playerScores.add(new PlayerScore(p)));
	}

	public void saveScore(int playerId, StrategyType strategyType, List<DiceResult> result) {
		PlayerScore playerScore = playerScores.stream()
				.filter(p -> p.getTableScoreId() == playerId).findAny().get();
		playerScore.saveScore(strategyType, result);
	}


}

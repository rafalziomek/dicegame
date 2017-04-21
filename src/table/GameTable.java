package table;

import java.util.Arrays;
import java.util.List;

import diceModel.DiceContainer;
import diceModel.DiceResult;
import player.Player;
import score.TableScore;
import strategies.Strategy;
import strategies.StrategyType;

public class GameTable {
	private TableScore tableScore;
	private DiceContainer diceContainer;
	private Player[] players;
	
	public GameTable(int numberOfPlayers) {
		players = new Player[numberOfPlayers];
		for(int i = 0; i < numberOfPlayers; i++) {
			players[i] = new Player(i);
		}
		tableScore = new TableScore(players);
		diceContainer = new DiceContainer(5);
	}
	
	public void movePlayer(int playerId, StrategyType strategyType, List<DiceResult> result) {
		tableScore.saveScore(playerId, strategyType, result);
	}

	private Player getPlayerById(int playerId) {
		Player player = Arrays.stream(players).filter(p -> (p.getId() == playerId)).findFirst().get();
		return player;
	}
}

package table;

import java.util.Arrays;

import diceModel.DiceContainer;
import player.Player;
import score.TableScore;
import strategies.Strategy;

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
	
	public void movePlayer(int playerId, Strategy strategy ) {
		tableScore.saveScore(playerId, strategy);
	}

	private Player getPlayerById(int playerId) {
		Player player = Arrays.stream(players).filter(p -> (p.getId() == playerId)).findFirst().get();
		return player;
	}
}

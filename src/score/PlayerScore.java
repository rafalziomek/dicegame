package score;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import diceModel.DiceResult;
import player.Player;
import strategies.Strategy;
import strategies.firstTableStrategies.FirstTableStrategy;
import strategies.secondTableStrategies.staticStrategies.SecondTableStaticStrategy;
import strategies.secondTableStrategies.sumStrategies.SecondTableSumStrategy;


public class PlayerScore {
	private int id;
	private Player player;
	private int firstTableScore;
	private int secondTableScore;
	private Map<Strategy, Boolean> usedStrategy;
	
	public PlayerScore(Player player) {
		this.player = player;
		firstTableScore = 0;
		secondTableScore = 0;
		id = player.getId();
		usedStrategy = new HashMap<Strategy, Boolean>();
	}
	public void saveScore(FirstTableStrategy strategy, List<DiceResult> result) {
		if(!matchClass(strategy)) {
			firstTableScore += strategy.getPoints(result);
			usedStrategy.put(strategy, true);
		}
		if(firstTableScore > 63) {
			firstTableScore += 25;
		}
	}
	
	public void saveScore(SecondTableStaticStrategy strategy, List<DiceResult> result) {
		saveScoreSecondTable(strategy, result);
	}
	
	public void saveScore(SecondTableSumStrategy strategy, List<DiceResult> result) {
		saveScoreSecondTable(strategy, result);
	}
	
	private void saveScoreSecondTable(Strategy strategy, List<DiceResult> result) {
		if(!matchClass(strategy)) {
			secondTableScore += strategy.getPoints(result);
			usedStrategy.put(strategy, true);
		}
	}
	
	private boolean matchClass(Strategy strategy) {
		return usedStrategy.keySet()
				.stream()
				.anyMatch(p -> p.getClass() == strategy.getClass());
	}
	public int getFirstTableScore() {
		return firstTableScore;
	}
	
	public int getScore() {
		return firstTableScore + secondTableScore;
	}
	
	public int getSecondTableScore() {
		return secondTableScore;
	}
	
	public int getTableScoreId(){
		return id;
	}
	
	
	
}

package strategies.firstTableStrategies;

import java.util.List;
import java.util.Map;

import diceModel.DiceResult;
import strategies.ResultStatistics;
import strategies.Strategy;

public abstract class FirstTableStrategy implements Strategy {
	private DiceResult diceResult;
	
	public FirstTableStrategy(DiceResult diceResult) {
		this.diceResult = diceResult;
	}
	
	@Override
	public int getPoints(List<DiceResult> results) {
		ResultStatistics resultStat = new ResultStatistics(results);
		Map<DiceResult, Integer> map = resultStat.counts();
		int points = map.get(diceResult)*diceResult.getValue();
		return points;
	}
	


	

}

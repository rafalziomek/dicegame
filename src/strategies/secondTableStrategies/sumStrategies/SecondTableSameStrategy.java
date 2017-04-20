package strategies.secondTableStrategies.sumStrategies;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import diceModel.DiceResult;
import strategies.ResultStatistics;
import strategies.secondTableStrategies.NumberOccurenceMatcher;

public abstract class SecondTableSameStrategy extends SecondTableSumStrategy {
	private int numberOfSame;
	
	public SecondTableSameStrategy(int numberOfSame) {
		super(false);
		this.numberOfSame = numberOfSame;
	}
	
	
	@Override
	public int getPoints(List<DiceResult> results) {
		this.condition = NumberOccurenceMatcher.getLargerThanOccurence(results, numberOfSame);
		return super.getPoints(results);
	}
	
	
	
	

}

package strategies.secondTableStrategies.staticStrategies;

import java.util.List;

import diceModel.DiceResult;
import strategies.secondTableStrategies.NumberOccurenceMatcher;

public class SecondTableFullStrategy extends SecondTableStaticStrategy {
	@Override
	public int getPoints(List<DiceResult> results) {
		boolean matchThree = NumberOccurenceMatcher.getEqualsOccurence(results, 3);
		boolean matchTwo = NumberOccurenceMatcher.getEqualsOccurence(results, 2);
		if(matchThree && matchTwo) {
			return 25;
		}
		return 0;
	}

	

}

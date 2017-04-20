package strategies.secondTableStrategies;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import diceModel.DiceResult;
import strategies.ResultStatistics;

public class NumberOccurenceMatcher {
	public static boolean getEqualsOccurence(List<DiceResult> results, int numberOfSame) {
		return getOccurence(results, numberOfSame, equals(numberOfSame));
	}
	public static boolean getLargerThanOccurence(List<DiceResult> results, int numberOfSame) {
		return getOccurence(results, numberOfSame, largerThan(numberOfSame));
	}
	
	private static boolean getOccurence(List<DiceResult> results, int numberOfSame, Predicate<? super Integer> predicate) {
		ResultStatistics resultStat = new ResultStatistics(results);
		Map<DiceResult, Integer> map = resultStat.counts();
		boolean theSame = map.values().stream().anyMatch(predicate);
		return theSame;
	}
	
	private static Predicate<? super Integer> largerThan(int numberOfSame) {
		return p -> p >= numberOfSame;
	}
	private static Predicate<? super Integer> equals(int numberOfSame) {
		return p -> p == numberOfSame;
	}
}

package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import diceModel.DiceResult;
import strategies.Strategy;
import strategies.firstTableStrategies.FirstTableStrategy;

public abstract class GetPointsTableStrategyTest {

	protected List<DiceResult> result;
	FirstTableStrategy firstTableStrategy;

	public GetPointsTableStrategyTest() {
		super();
	}

	protected void testPointsStrategy(Strategy strategy, List<DiceResult> result, int expectedPoints) {
		int points = strategy.getPoints(result);
		assertEquals(points, expectedPoints);
	}

}
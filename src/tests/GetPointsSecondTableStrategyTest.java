package tests;

import java.util.ArrayList;

import org.junit.Test;

import diceModel.DiceResult;
import strategies.Strategy;
import strategies.secondTableStrategies.*;
import strategies.secondTableStrategies.staticStrategies.SecondTableBigStraightStrategy;
import strategies.secondTableStrategies.staticStrategies.SecondTableFullStrategy;
import strategies.secondTableStrategies.staticStrategies.SecondTableGeneralStrategy;
import strategies.secondTableStrategies.staticStrategies.SecondTableSmallStraightStrategy;
import strategies.secondTableStrategies.sumStrategies.SecondTableChanceStrategy;
import strategies.secondTableStrategies.sumStrategies.SecondTableFourSameStrategy;
import strategies.secondTableStrategies.sumStrategies.SecondTableThreeSameStrategy;

public class GetPointsSecondTableStrategyTest extends GetPointsTableStrategyTest {

	@Test
	public void TestStrategies() {
		testChanceStrategy();
		testFourSameStrategy();
		testThreeSameStrategy();
		testFullStrategy();
		testGeneralStrategy();
		testSmallStraightStrategy();
		testBigStraightStrategy();
	}
	
	private void testChanceStrategy() {
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		testPointsStrategy(new SecondTableChanceStrategy(), result, 12);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.Two);
		result.add(DiceResult.Two);
		testPointsStrategy(new SecondTableChanceStrategy(), result, 7);
	}
	private void testFourSameStrategy() {
		Strategy strategy = new SecondTableFourSameStrategy();
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		testPointsStrategy(strategy, result, 0);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		testPointsStrategy(strategy, result, 13);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		testPointsStrategy(strategy, result, 15);
	}
	private void testThreeSameStrategy() {
		Strategy strategy = new SecondTableThreeSameStrategy();
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		testPointsStrategy(strategy, result, 12);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.Two);
		result.add(DiceResult.One);
		result.add(DiceResult.Two);
		result.add(DiceResult.One);
		testPointsStrategy(strategy, result, 7);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		testPointsStrategy(strategy, result, 13);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.One);
		result.add(DiceResult.Six);
		result.add(DiceResult.Six);
		testPointsStrategy(strategy, result, 0);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		testPointsStrategy(strategy, result, 15);
	}
	private void testFullStrategy() {
		Strategy strategy = new SecondTableFullStrategy();
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.Two);
		result.add(DiceResult.One);
		result.add(DiceResult.Two);
		result.add(DiceResult.One);
		testPointsStrategy(strategy, result, 25);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		testPointsStrategy(strategy, result, 0);
	}
	private void testGeneralStrategy() {
		Strategy strategy = new SecondTableGeneralStrategy();
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Six);
		result.add(DiceResult.Six);
		result.add(DiceResult.Six);
		result.add(DiceResult.Six);
		result.add(DiceResult.Six);
		testPointsStrategy(strategy, result, 50);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		testPointsStrategy(strategy, result, 0);
	}
	private void testSmallStraightStrategy() {
		Strategy strategy = new SecondTableSmallStraightStrategy();
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Two);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		result.add(DiceResult.Four);
		testPointsStrategy(strategy, result, 30);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Two);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Five);
		result.add(DiceResult.Four);
		testPointsStrategy(strategy, result, 30);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Two);
		result.add(DiceResult.Six);
		result.add(DiceResult.Three);
		result.add(DiceResult.Five);
		result.add(DiceResult.Four);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Three);
		result.add(DiceResult.Four);
		result.add(DiceResult.Six);
		result.add(DiceResult.Five);
		result.add(DiceResult.Four);
		testPointsStrategy(strategy, result, 30);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		testPointsStrategy(strategy, result, 0);
	}
	
	private void testBigStraightStrategy() {
		Strategy strategy = new SecondTableBigStraightStrategy();
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Two);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Five);
		result.add(DiceResult.Four);
		testPointsStrategy(strategy, result, 40);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Two);
		result.add(DiceResult.Six);
		result.add(DiceResult.Three);
		result.add(DiceResult.Five);
		result.add(DiceResult.Four);
		testPointsStrategy(strategy, result, 40);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		testPointsStrategy(strategy, result, 0);
	}
}

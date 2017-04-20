package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import diceModel.DiceResult;
import player.Player;
import score.PlayerScore;
import strategies.firstTableStrategies.FirstTableFiveStrategy;
import strategies.firstTableStrategies.FirstTableOneStrategy;
import strategies.firstTableStrategies.FirstTableSixStrategy;
import strategies.firstTableStrategies.FirstTableThreeStrategy;
import strategies.secondTableStrategies.staticStrategies.SecondTableBigStraightStrategy;
import strategies.secondTableStrategies.staticStrategies.SecondTableGeneralStrategy;
import strategies.secondTableStrategies.staticStrategies.SecondTableSmallStraightStrategy;
import strategies.secondTableStrategies.sumStrategies.SecondTableThreeSameStrategy;

public class PlayerScoreTest {
	private Player player1;
	private Player player2;
	private PlayerScore playerScore1;
	private PlayerScore playerScore2;
	private List<DiceResult> result;
	@Before
	public void initialize() {
		player1 = new Player(1);
		player2 = new Player(2);
	}
	
	@Test
	public void testAll() {
		testFirstTableScore();
		testSecondTableScore();
		testAbove63();
	}
	//Example game of one player with results
	private void testFirstTableScore() {
		playerScore1 = new PlayerScore(player1);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		
		playerScore1.saveScore(new FirstTableOneStrategy(), result);
		int score = playerScore1.getFirstTableScore();
		int expectedScore = 3;
		
		assertEquals(score, expectedScore);
		// the same strategy should do not add score
		playerScore1.saveScore(new FirstTableOneStrategy(), result);
		score = playerScore1.getScore();
		assertEquals(score, expectedScore);
		
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Two);
		result.add(DiceResult.One);
		result.add(DiceResult.Two);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		
		playerScore1.saveScore(new FirstTableSixStrategy(), result);
		score = playerScore1.getFirstTableScore();
		expectedScore = 9;
		assertEquals(score, expectedScore);
	}
	
	private void testSecondTableScore() {
		playerScore2 = new PlayerScore(player2);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		
		playerScore2.saveScore(new SecondTableGeneralStrategy(), result);
		
		int score = playerScore2.getSecondTableScore();
		int expectedScore = 50;
		
		assertEquals(score, expectedScore);
		// the same strategy should do not add score
		playerScore2.saveScore(new SecondTableGeneralStrategy(), result);
		score = playerScore2.getScore();
		assertEquals(score, expectedScore);
		
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.Two);
		result.add(DiceResult.Four);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		
		playerScore2.saveScore(new SecondTableSmallStraightStrategy(), result);
		score = playerScore2.getSecondTableScore();
		expectedScore = 80;
		assertEquals(score, expectedScore);
	}
	
	public void testScore() {
		playerScore2 = new PlayerScore(player2);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.Two);
		result.add(DiceResult.Three);
		result.add(DiceResult.Five);
		result.add(DiceResult.Six);
		
		playerScore2.saveScore(new SecondTableBigStraightStrategy(), result);
		
		int score = playerScore2.getScore();
		int expectedScore = 40;
		
		assertEquals(score, expectedScore);
		//the result do not has three same it should do not add
		playerScore2.saveScore(new SecondTableThreeSameStrategy(), result);
		score = playerScore2.getScore();
		assertEquals(score, expectedScore);
		
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.Two);
		result.add(DiceResult.Four);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		
		playerScore2.saveScore(new FirstTableSixStrategy(), result);
		score = playerScore2.getScore();
		expectedScore = 46;
		assertEquals(score, expectedScore);
	}
	
	private void testAbove63() {
		playerScore2 = new PlayerScore(player2);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Six);
		result.add(DiceResult.Six);
		result.add(DiceResult.Six);
		result.add(DiceResult.Six);
		result.add(DiceResult.Six);
		
		playerScore2.saveScore(new FirstTableSixStrategy(), result);
		
		int score = playerScore2.getScore();
		int expectedScore = 30;
		
		assertEquals(score, expectedScore);
		
		playerScore2.saveScore(new SecondTableThreeSameStrategy(), result);
		score = playerScore2.getScore();
		expectedScore = 60;
		assertEquals(score, expectedScore);
		
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Five);
		result.add(DiceResult.Five);
		result.add(DiceResult.Five);
		result.add(DiceResult.Five);
		result.add(DiceResult.Five);
		
		playerScore2.saveScore(new FirstTableFiveStrategy(), result);
		score = playerScore2.getScore();
		expectedScore = 85;
		assertEquals(score, expectedScore);
		
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		result.add(DiceResult.Three);
		
		playerScore2.saveScore(new FirstTableThreeStrategy(), result);
		score = playerScore2.getScore();
		expectedScore = 119;
		assertEquals(score, expectedScore);
	}
	
}

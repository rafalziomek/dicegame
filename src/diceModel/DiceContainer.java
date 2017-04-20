package diceModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DiceContainer {
	private Dice[] dices;
	
	public DiceContainer(int numberOfDices) {
		dices = new Dice[numberOfDices];
		Arrays.stream(dices).forEach(p -> p = new Dice());
	}
	
	public void rollAllDices() {
		Arrays.stream(dices).forEach(p -> p.RollADice());
	}
	
	public List<DiceResult> getTopOfDices() {
		List<DiceResult> topOfDices = Arrays.stream(dices).map(p -> p.getTopOfDice()).collect(Collectors.toList());
		return topOfDices;
		
	}
}

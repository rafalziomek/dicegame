package strategies;

import java.util.List;

import diceModel.DiceResult;

public interface Strategy {
	public int getPoints(List<DiceResult> results);
}

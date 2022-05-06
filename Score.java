package yolo;

import java.util.ArrayList;

public class Score {
	private int scoreOf1;
	private int scoreOf2;
	private int scoreOf3;
	private int scoreOf4;
	private int scoreOf5;
	private int scoreOf6;
	private int threeOfAKind;
	private int fourOfAKind;
	private int fullHouse;
	private int smStraight;
	private int lgStraight;
	private int yahtzee;
	private int chance;
	
	public Score() {
		scoreOf1 = -1;
		scoreOf2 = -1;
		scoreOf3 = -1;
		scoreOf4 = -1;
		scoreOf5 = -1;
		scoreOf6 = -1;
		threeOfAKind = -1;
		fourOfAKind = -1;
		fullHouse = -1;
		smStraight = -1;
		lgStraight = -1;
		yahtzee = -1;
		chance = -1;
	}
	
	public int total() {
		int total = 0;
		
		total += scoreOf1;
		total += scoreOf2;
		total += scoreOf3;
		total += scoreOf4;
		total += scoreOf5;
		total += scoreOf6;
		total += threeOfAKind;
		total += fourOfAKind;
		total += yahtzee;
		total += chance;
		total += fullHouse;
		total += smStraight;
		total += lgStraight;
		
		return total;
	}
	
	public void print() {
		System.out.println("\nScore Card: (-1 stands for not used yet)\n");
		System.out.println("Ones: " + this.scoreOf1);
		System.out.println("Twos: " + this.scoreOf2);
		System.out.println("Threes: " + this.scoreOf3);
		System.out.println("Fours: " + this.scoreOf4);
		System.out.println("Fives: " + this.scoreOf5);
		System.out.println("Sixes: " + this.scoreOf6);
		System.out.println("Three Of A Kind: " + this.threeOfAKind);
		System.out.println("Four Of A Kind: " + this.fourOfAKind);
		System.out.println("Chance: " + this.chance);
		System.out.println("FullHouse: " + this.fullHouse);
		System.out.println("Small Straight: " + this.smStraight);
		System.out.println("Large Straight: " + this.lgStraight);
		System.out.println("Yahtzee: " + this.yahtzee + "\n");
	}
	
	public boolean gameOver() {
		if (this.scoreOf1 != -1 && this.scoreOf2 != -1 && this.scoreOf3 != -1 && this.scoreOf4 != -1 && this.scoreOf5 != -1 && this.scoreOf6 != -1 && this.threeOfAKind != -1 && this.fourOfAKind != -1 && this.fullHouse != -1 && this.smStraight != -1 && this.lgStraight != -1 && this.yahtzee != -1) {
			return true;
		} else {
			return false;
		}
	}

	public int getScoreOf1() {
		return scoreOf1;
	}

	public void setScoreOf1(Dice[] dices) {
		int counter = 0;
		
		for (int a = 0; a < dices.length; a++) {
			if (dices[a].getValue() == 1) {
				counter++;
			}
		}
		
		this.scoreOf1 = counter;
	}

	public int getScoreOf2() {
		return scoreOf2;
	}

	public void setScoreOf2(Dice[] dices) {
		int counter = 0;
		
		for (int a = 0; a < dices.length; a++) {
			if (dices[a].getValue() == 2) {
				counter++;
			}
		}
		
		this.scoreOf2 = counter*2;
	}

	public int getScoreOf3() {
		return scoreOf3;
	}

	public void setScoreOf3(Dice[] dices) {
		int counter = 0;
		
		for (int a = 0; a < dices.length; a++) {
			if (dices[a].getValue() == 3) {
				counter++;
			}
		}
		
		this.scoreOf3 = counter*3;
	}

	public int getScoreOf4() {
		return scoreOf4;
	}

	public void setScoreOf4(Dice[] dices) {
		int counter = 0;
		
		for (int a = 0; a < dices.length; a++) {
			if (dices[a].getValue() == 4) {
				counter++;
			}
		}
		
		this.scoreOf4 = counter*4;
	}

	public int getScoreOf5() {
		return scoreOf5;
	}

	public void setScoreOf5(Dice[] dices) {
		int counter = 0;
		
		for (int a = 0; a < dices.length; a++) {
			if (dices[a].getValue() == 5) {
				counter++;
			}
		}
		
		this.scoreOf5 = counter*5;
	}

	public int getScoreOf6() {
		return scoreOf6;
	}

	public void setScoreOf6(Dice[] dices) {
		int counter = 0;
		
		for (int a = 0; a < dices.length; a++) {
			if (dices[a].getValue() == 6) {
				counter++;
			}
		}
		
		this.scoreOf6 = counter*6;
	}

	public int getThreeOfAKind() {
		return threeOfAKind;
	}

	public void setThreeOfAKind(Dice[] dices) {
		int value = 0;
		int chosenValue = -1;
		
		for (int a = 0; a < dices.length; a++) {
			int counter = 0;
			if (value != dices[a].getValue()) {
				value = dices[a].getValue();
				
				for (int b = a; b < dices.length; b++) {
					if (value == dices[b].getValue()) {
						counter++;
					}
				}
			}
			
			if (counter >= 3) {
				chosenValue = value;
			}
		}
		
		if (chosenValue != -1) {
			int total = 0;
			for (int a = 0; a < dices.length; a++) {
				total += dices[a].getValue();
			}
			this.threeOfAKind = total;
		} else {
			this.threeOfAKind = 0;
		}	
	}

	public int getFourOfAKind() {
		return fourOfAKind;
	}

	public void setFourOfAKind(Dice[] dices) {
		int value = 0;
		int chosenValue = -1;
		
		for (int a = 0; a < dices.length; a++) {
			int counter = 0;
			if (value != dices[a].getValue()) {
				value = dices[a].getValue();
				
				for (int b = a; b < dices.length; b++) {
					if (value == dices[b].getValue()) {
						counter++;
					}
				}
			}
			
			if (counter >= 4) {
				chosenValue = value;
			}
		}
		
		if (chosenValue != -1) {
			int total = 0;
			for (int a = 0; a < dices.length; a++) {
				total += dices[a].getValue();
			}
			this.fourOfAKind = total;
		} else {
			this.fourOfAKind = 0;
		}	
	}

	public int isFullHouse() {
		return fullHouse;
	}

	public void setFullHouse(Dice[] dices) {
		int value = 0;
		int chosenValue1 = -1;
		int chosenValue2 = -1;
		
		for (int a = 0; a < dices.length; a++) {
			int counter = 0;
			if (value != dices[a].getValue()) {
				value = dices[a].getValue();
				
				for (int b = a; b < dices.length; b++) {
					if (value == dices[b].getValue()) {
						counter++;
					}
				}
			}
			
			if (counter == 3) {
				chosenValue1 = value;
			} else if (counter == 2) {
				chosenValue2 = value;
			}
		}
		
		if (chosenValue1 != -1 && chosenValue2 != -1) {
			this.fullHouse = 25;
		} else {
			this.fullHouse = 0;
		}
	}

	public int isSmStraight() {
		return smStraight;
	}

	public void setSmStraight(Dice[] dices) {
		ArrayList<Integer> index = new ArrayList<Integer>();
		for (int a = 0; a < dices.length; a++) {
			index.add(dices[a].getValue());
		}
		
		for (int a = 1; a <= 3; a++) {
			if (index.contains(a) && index.contains(a+1) && index.contains(a+2) && index.contains(a+3)) {
				this.smStraight = 30;
			}
		}
		
		if (this.smStraight == -1) {
			smStraight = 0;
		}
	}

	public int isLgStraight() {
		return lgStraight;
	}

	public void setLgStraight(Dice[] dices) {
		ArrayList<Integer> index = new ArrayList<Integer>();
		for (int a = 0; a < dices.length; a++) {
			index.add(dices[a].getValue());
		}
		
		for (int a = 1; a <= 2; a++) {
			if (index.contains(a) && index.contains(a+1) && index.contains(a+2) && index.contains(a+3) && index.contains(a+4)) {
				this.lgStraight = 40;
			}
		}
		
		if (this.lgStraight == -1) {
			lgStraight = 0;
		}
	}

	public int getYahtzee() {
		return yahtzee;
	}

	public void setYahtzee(Dice[] dices) {
		int value = dices[0].getValue();
		boolean failed = false;
		
		for (int a = 1; a < dices.length; a++) {
			if (value != dices[a].getValue()) {
				failed = true;
			}
		}
		
		if (failed) {
			this.yahtzee = 0;
		} else {
			this.yahtzee = 50;
		}
	}

	public int getChance() {
		return chance;
	}

	public void setChance(Dice[] dices) {
		int total = 0;
		for (int a = 0; a < dices.length; a++) {
			total += dices[a].getValue();
		}
		this.chance = total;
	}
}

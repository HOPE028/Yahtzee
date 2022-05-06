package yolo;
//import java.util.Scanner;

public class Yahtzee {
	public static void main(String[] args) {

		Person human = new Person();
		int size = human.numOfPlayer();
		
		Score[] score = new Score[size];
		for (int a = 0; a < score.length; a++) {
			score[a] = new Score();
		}
		
		Dice[][] dices = new Dice[5][size];
		for (int a = 0; a < dices[0].length; a++) {
			dices[0][a] = new Dice();
			dices[1][a] = new Dice();
			dices[2][a] = new Dice(); 
			dices[3][a] = new Dice();
			dices[4][a] = new Dice();
		}
		
		boolean[] gameOver = new boolean[size];
		for (int a = 0; a < gameOver.length; a++) {
			gameOver[a] = false;
		}
		
		boolean moreRound;
		
		do {
			//roll all
			for (int a = 0; a < dices[0].length; a++) {
				dices[0][a].roll();
				dices[1][a].roll();
				dices[2][a].roll();
				dices[3][a].roll();
				dices[4][a].roll();
			}
			
			for (int a = 0; a < size; a++) {
				if (gameOver[a] == false) {
					human.playersTurn(a+1);
					
					//rolls
					dices = human.playerChooseDice(dices, a);
					
					
					//score
					int scoreSlot = human.playerChooseScore(score, a);
					score = scoreSlotFinder(scoreSlot, dices, score, a);
					score[a].print();
					
				}
			}
			
			moreRound = false;
			for (int a = 0; a < score.length; a++) {
				gameOver[a] = score[a].gameOver();
				if (gameOver[a] == false) {
					moreRound = true;
				}
			}
		} while (moreRound == true);
	}
	
	public static Score[] scoreSlotFinder(int scoreSlot, Dice[][] dices, Score[] score, int turn) {
		Dice[] tempDices = new Dice[5];
		
		for (int a = 0; a < 5; a++) {
			tempDices[a] = dices[a][turn];
		}
		
		if (scoreSlot == 1) {
			score[turn].setScoreOf1(tempDices);
		} else if (scoreSlot == 2) {
			score[turn].setScoreOf2(tempDices);
		} else if (scoreSlot == 3) {
			score[turn].setScoreOf3(tempDices);
		} else if (scoreSlot == 4) {
			score[turn].setScoreOf4(tempDices);
		} else if (scoreSlot == 5) {
			score[turn].setScoreOf5(tempDices);
		} else if (scoreSlot == 6){
			score[turn].setScoreOf6(tempDices);
		} else if (scoreSlot == 333) {
			score[turn].setThreeOfAKind(tempDices);
		} else if (scoreSlot == 4444) {
			score[turn].setFourOfAKind(tempDices);
		} else if (scoreSlot == 11100) {
			score[turn].setFullHouse(tempDices);
		} else if (scoreSlot == 1234) {
			score[turn].setSmStraight(tempDices);
		} else if (scoreSlot == 12345) {
			score[turn].setLgStraight(tempDices);
		} else if (scoreSlot == 55555) {
			score[turn].setYahtzee(tempDices);
		} else {
			score[turn].setChance(tempDices);
		}
		
		return score;
	}
	
}



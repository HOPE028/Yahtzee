package yolo;
import java.util.Scanner;

public class Person {
	private Scanner in = new Scanner(System.in);
	
	public Dice[][] playerChooseDice(Dice[][] dices, int turn) {
		for (int i = 0; i < 3; i++) {
			print(dices, "Roll:", turn);
			
			System.out.println("Please insert how many dice you would like to reroll: (Enter '0' if nothing OR Enter '5' for everything)");
			int size = in.nextInt();
			
			if (size > 5) {
				do {
					System.out.println("The number you chose was more then five. Please insert how many dice you would like to reroll: (Enter '0' if nothing)");
					size = in.nextInt();
				} while (size > 5);
			}
			
			//code in case they are happy with their roll
			if (size <= 0) {
				break;
			}
			
			int[] reRoll = new int[size];
			
			//code in case they aren't happy with anything
			
			if (size == 5) {
				reRoll[0] = 0;
				reRoll[1] = 1;
				reRoll[2] = 2;
				reRoll[3] = 3;
				reRoll[4] = 4;
			} else { //code for specific dice
				System.out.println("Please insert the " + size + " dice you would like to reroll (1-5)");
				
				for (int a = 0; a < reRoll.length; a++) {
					reRoll[a] = in.nextInt()-1;
					
					if (reRoll[a] >= 5 || reRoll[a] < 0) {
						do {
							System.out.println("The die you chose was not possible. Please insert the die you would like to reroll (1-5))");
							reRoll[a] = in.nextInt()-1;
						} while (reRoll[a] >= 5 || reRoll[a] < 0);
					}
				} 
			}
			
			dices = roll(reRoll, dices, turn);
		}
		print(dices, "Your Final Dice are:", turn);
		return dices;
	}
	
	public Dice[][] roll(int[] reRoll, Dice[][] dices, int turn) {
		for (int a = 0; a < reRoll.length; a++) {
			dices[reRoll[a]][turn].roll();
		}
		return dices;
	}
	
	public void playersTurn(int player) {
		System.out.println("It is player " + player + "'s turn\n");
	}
	
	public int numOfPlayer() {
		System.out.println("Hello user(s)! How many players will be participating tonight: (1-9999999)");
		int size = in.nextInt();
		if (size < 1 || size > 9999999) {
			do {
				System.out.println("That input is not valid. Please enter how many players will participating tonight: (1-9999999)");
				size = in.nextInt();
			} while (size < 1 || size > 9999999);
		}
		System.out.println();
		return size;
	}
	
	public void print(Dice[][] dices, String str, int turn) {
		System.out.println(str);
		for (int a = 0; a < dices.length; a++) {
			
			System.out.print(a+1 + ".");
			
			if (dices[a][turn].getValue() == 1) {
				System.out.print("⚀");
			} else if (dices[a][turn].getValue() == 2) {
				System.out.print("⚁");
			} else if (dices[a][turn].getValue() == 3) {
				System.out.print("⚂");
			} else if (dices[a][turn].getValue() == 4) {
				System.out.print("⚃");
			} else if (dices[a][turn].getValue() == 5) {
				System.out.print("⚄");
			} else {
				System.out.print("⚅");
			}
			System.out.print("\t");
		}
		
		System.out.println("\n");
	}
	
	public int playerChooseScore(Score[] score, int turn) {
		
		System.out.println("Upper Section:    1:aces  •  2:twos  •  3:threes  •  4:fours  •  5:fives  •  6:sixes\n\nLower Section:    333:Three Of A Kind  •  4444:Four Of A Kind  •  11100:Full House\n                  1234:Four Straight  •  12345:Five Straight  •  55555:Yachtzee  •  999:Choice\n");
		boolean found = false;
		int pointChosen = 0;
		
		while (! found) {
			System.out.println("Please insert how you would like to score it: Insert Key -- (Key):(Value)\n");
			pointChosen = in.nextInt();
			if (pointChosen <= 0 || pointChosen >= 7 && pointChosen != 333 && pointChosen != 4444 && pointChosen != 11100 && pointChosen != 1234 && pointChosen != 12345 && pointChosen != 55555 && pointChosen != 999) {
				do {
					System.out.println("The Key you chose was not possible. Please insert the Key you would like");
					pointChosen = in.nextInt();
				} while (pointChosen <= 0 || pointChosen >= 7 && pointChosen != 333 && pointChosen != 4444 && pointChosen != 11100 && pointChosen != 1234 && pointChosen != 12345 && pointChosen != 55555 && pointChosen != 999);
			}
			if (pointChosen == 333 && score[turn].getThreeOfAKind() == -1) {
				found = !found;
			} else if (pointChosen == 4444 && score[turn].getFourOfAKind() == -1) {
				found = !found;
			} else if (pointChosen == 11100 && score[turn].isFullHouse() == -1) {
				found = !found;
			} else if (pointChosen == 1234 && score[turn].isSmStraight() == -1) {
				found = !found;
			} else if (pointChosen == 12345 && score[turn].isLgStraight() == -1) {
				found = !found;
			} else if (pointChosen == 55555 && score[turn].getYahtzee() == -1) {
				found = !found;
			} else if (pointChosen == 999 && score[turn].getChance() == -1) {
				found = !found;
			} else if (pointChosen == 1 && score[turn].getScoreOf1() == -1) {
				found = !found;
			} else if (pointChosen == 2 && score[turn].getScoreOf2() == -1) {
				found = !found;
			} else if (pointChosen == 3 && score[turn].getScoreOf3() == -1) {
				found = !found;
			} else if (pointChosen == 4 && score[turn].getScoreOf4() == -1) {
				found = !found;
			} else if (pointChosen == 5 && score[turn].getScoreOf5() == -1) {
				found = !found;
			} else if (pointChosen == 6 && score[turn].getScoreOf6() == -1) {
				found = !found;
			}
		}
		
		return pointChosen;
	}
}











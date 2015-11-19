import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DiceWeek10{

	public static void main(String[] args)

	{

		Scanner myKeyboard = new Scanner(System.in);
		String doAgain;
		int gameCount = 0;
		Random myRNG = new Random();
		int myChoice;

		int size = 20; 
		int i = 0;
		int [] winGame = new int [size];
		int [] evenCount = new int [size];
		int [] oddCount = new int [size];
		int [] winPercent = new int [size];
		int [] cpuArray = new int [size];

		int nDices = Integer.parseInt(JOptionPane.showInputDialog("Enter # of dices: "));
		Dice tDice = new Dice(nDices);

		do {

			myChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Now guess the number: "));
			int cpuChoice = tDice.GetaNumber();

			cpuArray[i] = cpuChoice;


			while (myChoice < 1 || myChoice > tDice.Limit())
			{
				if(myChoice < 1 )
				{
					JOptionPane.showMessageDialog(null, String.format("Too low.\nNumber must be within 1 and " + tDice.Limit() + ".\nEnter a higher number."));
				}
				else if (myChoice > tDice.Limit())
				{
					JOptionPane.showMessageDialog(null, String.format("Too high.\nNumber must be within 1 and " + tDice.Limit() + ".\nEnter a lower number."));
				}
				myChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Try to guess the number (1-10)."));
			}
			if (myChoice == cpuChoice) 
			{

				JOptionPane.showMessageDialog(null, "You did it!");
				if (myChoice % 2 == 0)
				{
					evenCount[i] = myChoice;

				}
				else if (myChoice % 2 != 0)
				{
					oddCount[i] = myChoice;										
				}
				winGame[i] = 1;

			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Nope!, the number was " + cpuChoice + ".");
				if (myChoice % 2 == 0)
				{
					evenCount[i] = myChoice;
				}
				else if (myChoice % 2 != 0)
				{
					oddCount[i] = myChoice;						
				}
				winGame[i] = 0;
			}
			i++;
			gameCount++;
			doAgain = JOptionPane.showInputDialog("Play again? (Y/N)").toUpperCase();
			while(!(doAgain.matches("[YN]+"))) 
			{				
				JOptionPane.showMessageDialog(null, "Error! Error! Invalid.");
				doAgain = JOptionPane.showInputDialog("again? (Y/N)").toUpperCase();

			}

		} while (!(doAgain.equals("N")));
		JOptionPane.showMessageDialog(null,"Bye Bye!");

		for (int a=0; a <evenCount.length; a++)
		{
			System.out.println("Even Guesses: " + evenCount[a]);
		}
		for (int b=0; b < oddCount.length; b++)
		{
			System.out.println("Odd Guesses " + b + ": " + oddCount[b]);
		}
		for (int c=0; c < winGame.length; c++)
		{
			System.out.println("Wins " + winGame[c]);
		}
		for (int d=0; d < cpuArray.length; d++)
		{
			System.out.println("Computer Numbers: " + cpuArray[d]);
		}
	}

}
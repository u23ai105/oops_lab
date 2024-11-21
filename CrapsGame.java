package lab678;
import java.util.Random;
import java.util.Scanner;
public class CrapsGame {
	public enum Status{
		WIN,LOSE,CONTINUE;
	}
	private int point;
	private Random random=new Random();
	private int rollDice() {
		int die1=1+random.nextInt(6);
		int die2=1+random.nextInt(6);
		int sum=die1+die2;
		System.out.println("you rolled : die1 - "+die1+" die2 - "+die2);
		return sum; 
	}
	public void play() {
		Status gamestatus;
		int sumofdice=rollDice();
		switch(sumofdice) {
		case 7:
		case 11:
			gamestatus=Status.WIN;
			break;
		case 2:
		case 3:
		case 12:
			gamestatus=Status.LOSE;
			break;
		default :
			gamestatus=Status.CONTINUE;
			point=sumofdice;
			System.out.println("Point is set to "+point);
			break;
		}
		while(gamestatus==Status.CONTINUE) {
			int sum=rollDice();
			if(sum==7) gamestatus=Status.LOSE;
			else if(sum==point) gamestatus=Status.WIN;
		}
		if(gamestatus==Status.WIN) System.out.println("You Won");
		else  System.out.println("You Lose");
	}

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		CrapsGame game=new CrapsGame();
		int playagain;
		do {
			game.play();
			System.out.println("Do you want to play again ?? (1,0) ");
			playagain=scanner.nextInt();
		}while(playagain==1);
		scanner.close();
		}
	}

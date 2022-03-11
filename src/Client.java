import java.util.Scanner;


public class Client {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		int player = 1;
		System.out.println(Logic.showBoard());
		for (int i=0;i<255;i++) {
			System.out.println("Player "+((player==1)?"1":"2")+">");
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (Logic.deploy(x, y, player)) {
				System.out.println(Logic.showBoard());
				if (Logic.checkWins()) {
					System.out.println("Great! Player "+((player==1)?"1":"2")+" Wins!");
					return;
				}
				player = -player;
			} else {
				System.out.println("Wrong position:(. Please try again.");
			}
		}
		System.out.println("Good job guys. It is a tile.");
	}
}

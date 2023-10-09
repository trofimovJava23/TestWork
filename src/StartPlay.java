import static java.lang.System.out;

public class StartPlay {

	public static void main(String[] args) {
		Entity NewPlayer = new Player(50, 50, 50, 50);
		out.printf("New player attack is : " + NewPlayer.attack + "\n");
		Monster NewMonster = new Monster(50,50,50,50);
		out.printf("New monster attack is : " + NewMonster.attack + "\n");
	}

}

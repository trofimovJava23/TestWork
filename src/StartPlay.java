import static java.lang.System.out;

public class StartPlay {

	public static void main(String[] args) {
		
		Player NewPlayer = new Player(10, 1, 50, 100,1,6);
		Monster NewMonster = new Monster(3,2,50,100,1,6);
		new PlayFrame();
		NewPlayer.HitEnemy(NewMonster);
		//out.print(NewPlayer.damage.length + "\n");
		
	}

}

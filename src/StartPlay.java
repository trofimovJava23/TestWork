import static java.lang.System.out;

public class StartPlay {

	public static void main(String[] args) {
		//Entity NewEntity = new Entity(50,50,50,100,1,6);
		Player NewPlayer = new Player(10, 1, 50, 100,1,6);
		Monster NewMonster = new Monster(3,2,50,100,1,6);
				
		NewPlayer.HitEnemy(NewMonster);
		out.print(NewPlayer.damage.length + "\n");
		
	}

}

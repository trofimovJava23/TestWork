import static java.lang.System.out;

public class StartPlay {

	public static void main(String[] args) {
		Entity NewEntity = new Entity(50,50,50,100,1,6);
		Player NewPlayer = new Player(50, 50, 50, 100,1,6);
		Monster NewMonster = new Monster(50,50,50,100,1,6);
		for (int i=0; i<NewMonster.damage.length; i++) {
		out.printf("Массив Damage, член №" + i+ ":" + NewMonster.damage[i] + "\n");
		}
	}

}

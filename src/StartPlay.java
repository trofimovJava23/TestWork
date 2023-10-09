import static java.lang.System.out;

public class StartPlay {

	public static void main(String[] args) {
		Entity NewEntity = new Entity(50,50,50,100);
		Player NewPlayer = new Player(50, 50, 50, 100);
		Monster NewMonster = new Monster(50,50,50,100);
		
		out.printf("Heal amount : " + NewMonster.healAmount + "\n");
		out.printf("result " + NewMonster.Heal()+ "\n");
		out.printf("result " + NewMonster.Heal()+ "\n");
		out.printf("result " + NewMonster.Heal()+ "\n");
		out.printf("result " + NewMonster.Heal()+ "\n");
		out.printf("result " + NewMonster.Heal()+ "\n");
		out.printf("Health:" + NewMonster.health + "\n" + NewMonster.numberOfHeals + "\n");
		
	}

}

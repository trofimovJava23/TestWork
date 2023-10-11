
public class Player extends Entity {
	public Player (int attack, int defence, int health, int healthMax, int minDamage, int maxDamage) {
		super(attack,defence,health,healthMax, minDamage, maxDamage);
	}
	public Player getPlayerFromEntity(Entity someEntity) {
		Player somePlayer = new Player(someEntity.attack,someEntity.defence,someEntity.health,someEntity.healthMax,someEntity.minDamage,someEntity.maxDamage);
		return somePlayer;
	}
	
}


public class Monster extends Entity {

	public Monster(int attack, int defence, int health, int healthMax, int minDamage, int maxDamage) {
		super(attack,defence,health,healthMax, minDamage, maxDamage);
	}

	public Monster getMonsterFromEntity(Entity someEntity) {
		Monster someMonster = new Monster (someEntity.attack,someEntity.defence,someEntity.health,someEntity.healthMax,someEntity.minDamage,someEntity.maxDamage);
		return someMonster;
	}
	
	public boolean autoHeal() {
		if ((double) this.health < 0.3*this.healthMax) {
			this.Heal();
			return true;
		} else {
			return false;
		}
	}
}

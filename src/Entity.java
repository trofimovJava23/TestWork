import java.lang.Math;
import java.lang.Long;

public class Entity {

int attack; //entered [1..30] ???
int defence; //entered [1..30] ???


int health; //entered [1..healthMax] ???
int healthMax;
int numberOfHeals = 0; //entered [0..4]
int healAmount;

public boolean Heal() {
	if (numberOfHeals < 4) {
		this.health = this.health + healAmount;
		if (this.health > healthMax) {
			this.health = healthMax;
		}
		this.numberOfHeals++;
		return true;
	}
	else {return false;}
	
}

int damage[]; //collection of int M..N
public void Fight() {
	
}
public Entity(int attack, int defence, int health, int healthMax) {
	this.attack = attack;
	this.defence = defence;
	this.health = health;
	this.healthMax = healthMax;
	this.healAmount = (int) (healthMax*0.3); //amount of Heal
}


}

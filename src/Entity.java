import java.lang.Double;

public class Entity {

int attack; //entered [1..30] , need init
int defence; //entered [1..30] , need init


int health; //entered [1..healthMax], need init
int healthMax;
int numberOfHeals = 0; //entered [0..4]
public void Heal() {
	
}

int damage[]; //collection of int M..N
public void Fight() {
	
}
public Entity(int attack, int defence, int health, int healthMax) {
	this.attack = attack;
	this.defence = defence;
	this.health = health;
	this.healthMax = healthMax;
}


}

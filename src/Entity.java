import java.lang.Math;
import java.lang.Long;

public class Entity {

static int attack; //entered [1..30] ??? 
static int defence; //entered [1..30] ???


int health; //entered [1..healthMax] ???
static int healthMax;//Max value for health
int numberOfHeals = 0; //entered [0..4]
static int healAmount;
static int minDamage, maxDamage; // min and max for Damage collection
static int damage[]; //collection of int minDamage...maxDamage

//Method for heal Entity
public boolean Heal() { // в случае если лечение возможно и было осуществлено возвращаем true
	if (numberOfHeals < 4) && (this.health != this.healthMax) {
		this.health = this.health + healAmount; //увеличивам значение здоровья на значение, равное 30% от максимального, инициализированное в конструкторе
		if (this.health > healthMax) { //если превышает максимальное количество здоровья, то присваиваем его
			this.health = healthMax;
		}
		this.numberOfHeals++; // счетчик количества лечений
		return true;
	}
	else {return false;}
	
}


public void Fight() {
	
}
public Entity(int attack, int defence, int health, int healthMax, int minDamage, int maxDamage) {
	this.attack = attack;
	this.defence = defence;
	this.health = health;
	this.healthMax = healthMax;
	this.healAmount = (int) (healthMax*0.3); //amount of Heal
	this.damage = new int[maxDamage - minDamage +1]; // add Damage collection size of max-min 
	for (int count = 0; count<(maxDamage-minDamage +1); count++) {
		this.damage[count]=minDamage+count;
	}
}


}

import java.util.Random;

import static java.lang.System.out;

public class Entity {

final int attack; //entered [1..30] ??? 
final int defence; //entered [1..30] ???


int health; //entered [1..healthMax] ???
final int healthMax;//Max value for health
int numberOfHeals = 0; //entered [0..4]
int healAmount;
int minDamage, maxDamage; // min and max for Damage collection
int damage[]; //collection of int minDamage...maxDamage
boolean alive = true; //alive or nor alive



//конструктор
public Entity(int attack, int defence, int health, int healthMax, int minDamage, int maxDamage) {
	this.attack = attack;
	this.defence = defence;
	this.health = health;
	this.healthMax = healthMax;
	this.healAmount = (int) (healthMax*0.3); //amount of Heal
	if (this.healAmount == 0) {
		this.healAmount = 1;
	}
	this.damage = new int[maxDamage - minDamage +1]; // add Damage collection size of max-min 
	for (int count = 0; count<(maxDamage-minDamage +1); count++) {
		this.damage[count]=minDamage+count;
	}
}

//Method for heal Entity
public boolean Heal() { // в случае если лечение возможно и было осуществлено возвращаем true
	if ((numberOfHeals < 4) && (this.health != this.healthMax)) {
		this.health = this.health + healAmount; //увеличивам значение здоровья на значение, равное 30% от максимального, инициализированное в конструкторе
		if (this.health > healthMax) { //если превышает максимальное количество здоровья, то присваиваем его
			this.health = healthMax;
		}
		this.numberOfHeals++; // счетчик количества лечений
		return true;
	}
	else {return false;}
	
}

public int HitEnemy(Entity Receiving) {
	int modOfAttack = this.attack - Receiving.defence; // 
	boolean doDamage = false; //флаг на нанесение урона
	int counter = 0; //счетчик количества бросков
		do {
			int Dice = new Random().nextInt(6)+1; //бросок кубика
			counter++; //увеличиваем счетчик
			if (Dice>=5) {
				doDamage = true; //если выпало 5 или 6 изменяем значение флага
			}
		} while ((counter < modOfAttack)&&(doDamage == false));
	int randomPoint = new Random().nextInt(this.damage.length); // выбираем рандомное число
	//out.printf("Здоровье до удара:" + Receiving.health + "\n");
	Receiving.health = Receiving.health - damage[randomPoint]; // наносим урон по рандомному указателю из массива damage
	if (Receiving.health <= 0) {
		Receiving.health = 0;
		Receiving.alive = false; // если количество хп меньше либо равно нулю существо погибает
	}
	//out.printf("Здоровье после удара:" + Receiving.health + "\n");
	return damage[randomPoint];
}

}

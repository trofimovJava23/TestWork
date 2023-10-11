import javax.swing.JLabel;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Box;



class EnterFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID =1L;
	
	int attack,defence,health,healthMax,minDamage,maxDamage;
	int flag = 2; //если равно 0 - вводим данные игрока, если 1 - монстра
		
	JLabel HelloLabel = new JLabel("Приветствую! Введите данные, затем нажмите кнопку ВВЕСТИ ПАРАМЕТРЫ");
		
	JLabel AttackLabel = new JLabel("Параметр атаки (от 1 до 30)");
	JLabel DefenceLabel = new JLabel("Параметр защиты (от 1 до 30)");
	JLabel HealthLabel = new JLabel("Параметр текущего здоровья");
	JLabel HealthMaxLabel = new JLabel("Параметр максимального здоровья");
	JLabel MinDamageLabel = new JLabel("Минимальное значение урона");
	JLabel MaxDamageLabel = new JLabel("Максимальное значение урона");
	JTextField textFieldAttack = new JTextField(5);
	JTextField textFieldDefence = new JTextField(5);
	JTextField textFieldHealth = new JTextField(5);
	JTextField textFieldHealthMax = new JTextField(5);
	JTextField textFieldMinDamage = new JTextField(5);
	JTextField textFieldMaxDamage = new JTextField(5);
	JButton saveButton = new JButton("Ввести параметры");
	
	
	 
	
	public EnterFrame(int flag) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.flag = flag;
		add(HelloLabel);
		add(Box.createHorizontalStrut(400));
		add(AttackLabel);
		add(textFieldAttack);
		add(Box.createHorizontalStrut(50));
		add(DefenceLabel);
		add(textFieldDefence);
		add(HealthLabel);
		add(textFieldHealth);
		add(HealthMaxLabel);
		add(textFieldHealthMax);
		add(MinDamageLabel);
		add(textFieldMinDamage);
		add(MaxDamageLabel);
		add(textFieldMaxDamage);
		add(saveButton);
		saveButton.addActionListener(this);
		pack();
		setSize(550, 400);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			attack = Integer.parseInt(textFieldAttack.getText());
			if ((attack < 1) | (attack > 30)) {
				throw new OutOfRangeException("Параметр атаки должен быть в пределах от 1 до 30");
			}
			defence = Integer.parseInt(textFieldDefence.getText());
			if ((defence < 1) | (defence > 30)) {
				throw new OutOfRangeException("Параметр защиты должен быть в пределах от 1 до 30");
			}
			health = Integer.parseInt(textFieldHealth.getText());
			if (health < 1) {
				throw new OutOfRangeException("Параметр здоровья должен быть положительным целым числом");
			}
			healthMax = Integer.parseInt(textFieldHealthMax.getText());
			if (healthMax < health) {
				throw new OutOfRangeException("Параметр максимального здоровья может быть больше либо равен текущему показателю здоровья");
			}
			minDamage = Integer.parseInt(textFieldMinDamage.getText());
			if (minDamage < 1) {
				throw new OutOfRangeException("Минимальнок значение урона не может быть меньше единицы");
			}
			maxDamage = Integer.parseInt(textFieldMaxDamage.getText());
			if (maxDamage <= minDamage) {
				throw new OutOfRangeException("Максимальное значение урона должно быть больше минимального");
			}
			if (flag ==0) {
				PlayFrame.readyPlayer = new Player(attack,defence,health,healthMax,minDamage,maxDamage);
			} else if (flag == 1) {
				PlayFrame.readyMonster = new Monster(attack,defence,health,healthMax,minDamage,maxDamage);
			}
			
			setVisible(false);		
		} catch (NumberFormatException errFormat) {
			new InfoFrame("Вводите только положительные целые числа и заполните все поля");
		} catch (OutOfRangeException errAmount) {	
		}
		
		
	}
			
}

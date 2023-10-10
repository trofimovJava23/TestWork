import javax.swing.JLabel;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JComboBox;
import static java.lang.System.out;

class GameFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID =1L;
	JLabel HelloLabel = new JLabel("Приветствую! Введите данные для игрока и монстра, затем нажмите кнопку НАЧАТЬ");
	String[] MassEntity = {
			"Игрок",
			"Монстр",
		};
	JComboBox SwitchEntity = new JComboBox(MassEntity);
	
	
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
	JButton startButton = new JButton("Начать игру");
	
	 
	
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(HelloLabel);
		add(Box.createHorizontalStrut(20));
		add(SwitchEntity);
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
		add(Box.createHorizontalStrut(100));
		add(startButton);
		saveButton.addActionListener(this);
		pack();
		setSize(600, 400);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int attack = Integer.parseInt(textFieldAttack.getText());
			int defence = Integer.parseInt(textFieldDefence.getText());
			int health = Integer.parseInt(textFieldHealth.getText());
			int healthMax = Integer.parseInt(textFieldHealthMax.getText());
			int minDamage = Integer.parseInt(textFieldMinDamage.getText());
			int maxDamage = Integer.parseInt(textFieldMaxDamage.getText());
			if (SwitchEntity.getSelectedItem().equals("Игрок")) {
				Player NewPlayer = new Player(attack, defence, health, healthMax, minDamage, maxDamage);
				out.printf(" " + NewPlayer.attack);
							
			} else if (SwitchEntity.getSelectedItem().equals("Монстр")){
				Monster NewMonster = new Monster(attack, defence, health, healthMax, minDamage, maxDamage);
			}
		} catch (NumberFormatException errFormat) {
			new ErrorFrame("Неверный формат");
		}
		
	}
}

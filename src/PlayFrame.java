import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class PlayFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID =1L;
	
	JLabel HelloLabel = new JLabel("Приветствую! Введите данные для игрока и монстра, затем нажмите кнопку ИГРАТЬ");
	JButton addPlayerButton = new JButton("Добавить игрока");
	JButton addMonsterButton = new JButton("Добавить монстра");
	JButton startButton = new JButton("Начать игру");
	
	
static Player readyPlayer = new Player(0,0,0,0,0,0); //создаем игрока и монстра и инициализируем их
static Monster readyMonster = new Monster(0,0,0,0,0,0);


public PlayFrame() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout(FlowLayout.CENTER));
	add(HelloLabel);
	add(Box.createHorizontalStrut(400));
	add(addPlayerButton);
	add(addMonsterButton);
	add(startButton);
	addPlayerButton.addActionListener(this);
	addMonsterButton.addActionListener(this);
	startButton.addActionListener(this);
	addMonsterButton.setEnabled(false);
	startButton.setEnabled(false);
	pack();
	setSize(550, 100);
	setVisible(true);
	
}


@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource().equals(addPlayerButton)) { //добавить игрока - EnterFrame с параметром 0
		new EnterFrame(0);
		addPlayerButton.setEnabled(false);
		addMonsterButton.setEnabled(true);
		}
	else if (e.getSource().equals(addMonsterButton)) { //добавить монстра - EnterFrame с параметром 1
		new EnterFrame(1);
		addMonsterButton.setEnabled(false);
		startButton.setEnabled(true);
		}
	else if ((e.getSource().equals(startButton)) & (PlayFrame.readyMonster.health > 0)) { //проверяем дополнительно готов ли монстр
		if ((addPlayerButton.isEnabled() & addMonsterButton.isEnabled()) == false) { // если кнопки доступны значит данные не ввели
			setVisible(false);
			new FightFrame();
		} else {
			new InfoFrame("Вы не готовы начать, введите данные");
		}
	}
	
}

}

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static java.lang.System.out;

public class PlayFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID =1L;
	
	JLabel HelloLabel = new JLabel("Приветствую! Введите данные для игрока и монстра, затем нажмите кнопку ИГРАТЬ");
	JButton addPlayerButton = new JButton("Добавить игрока");
	JButton addMonsterButton = new JButton("Добавить монстра");
	JButton startButton = new JButton("Начать игру");
	
	
static Player readyPlayer = new Player(0,0,0,0,0,0);
static Monster readyMonster = new Monster(0,0,0,0,0,0);
static Entity readyEntity = new Entity(0,0,0,0,0,0); //буфер

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
	pack();
	setSize(550, 100);
	setVisible(true);
	
}

/**
 *
 */
@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource().equals(addPlayerButton)) {
		new EnterFrame(0);
		addPlayerButton.setEnabled(false);	
		}
	else if (e.getSource().equals(addMonsterButton)) {
		new EnterFrame(1);
		addMonsterButton.setEnabled(false);
		}
	else if (e.getSource().equals(startButton)) {
		if ((addPlayerButton.isEnabled() & addMonsterButton.isEnabled()) == false) {
			setVisible(false);
			new FightFrame();
		} else {
			new InfoFrame("Вы не готовы начать, введите данные");
		}
	}
	
}

}

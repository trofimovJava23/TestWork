import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class FightFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID =1L;
	
	JLabel playerLabel = new JLabel("Текущее здоровье игрока:  "+Integer.toString(PlayFrame.readyPlayer.health));
	JLabel monsterLabel = new JLabel("Текущее здоровье монстра:  "+Integer.toString(PlayFrame.readyMonster.health));
	Runnable UpdateInfo = new Runnable() {
	public void run() {
		playerLabel.setText("Текущее здоровье игрока:  "+Integer.toString(PlayFrame.readyPlayer.health));
		monsterLabel.setText("Текущее здоровье монстра:  "+Integer.toString(PlayFrame.readyMonster.health));
	     }
	 };
	
	JButton makeMove = new JButton("Сделать ход");
	JButton takeHeal = new JButton("Полечиться");
	
	public FightFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		add(playerLabel);
		add(Box.createHorizontalStrut(400));
		add(monsterLabel);
		add(Box.createHorizontalStrut(400));
		add(makeMove);
		add(takeHeal);
		makeMove.addActionListener(this);
		takeHeal.addActionListener(this);
		pack();
		setSize(400, 150);
		setVisible(true);
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(makeMove)) {
			PlayFrame.readyPlayer.HitEnemy(PlayFrame.readyMonster);
			SwingUtilities.invokeLater(UpdateInfo);
			}
		else if (e.getSource().equals(takeHeal)) {
			if (PlayFrame.readyPlayer.Heal()){
				new InfoFrame("Вы полечились");
				SwingUtilities.invokeLater(UpdateInfo);
				
			} else {
				new InfoFrame("Закончились хилки");
				playerLabel.updateUI();
				SwingUtilities.invokeLater(UpdateInfo);
			}
			}
		
	}
	
	
}

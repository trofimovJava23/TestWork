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
	
	JLabel playerLabel = new JLabel("Текущее здоровье игрока:  "+Integer.toString(PlayFrame.readyPlayer.health)+"  Потрачено хилок: " + Integer.toString(PlayFrame.readyPlayer.numberOfHeals) + " Из 4");
	JLabel monsterLabel = new JLabel("Текущее здоровье монстра:  "+Integer.toString(PlayFrame.readyMonster.health)+"  Потрачено хилок: " + Integer.toString(PlayFrame.readyMonster.numberOfHeals) + " Из 4");
	//Создаем UpdateInfo для изменения двух лейблов с использованием метода SwingUtilities.invokeLater
	Runnable UpdateInfo = new Runnable() {
	public void run() {
		playerLabel.setText("Текущее здоровье игрока:  "+Integer.toString(PlayFrame.readyPlayer.health)+"  Потрачено хилок: " + Integer.toString(PlayFrame.readyPlayer.numberOfHeals) + " Из 4");
		monsterLabel.setText("Текущее здоровье монстра:  "+Integer.toString(PlayFrame.readyMonster.health)+"  Потрачено хилок: " + Integer.toString(PlayFrame.readyMonster.numberOfHeals) + " Из 4");
	     }
	 };
	
	JButton makeMove = new JButton("Сделать ход");
	JButton takeHeal = new JButton("Полечиться");
	
	public FightFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
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
		if (e.getSource().equals(makeMove)) { // при нажатии кнопки сделать ход
			int playerDamage = PlayFrame.readyPlayer.HitEnemy(PlayFrame.readyMonster); //наносим урон с помощью метода HitEnemy из класса Entity
			if (PlayFrame.readyMonster.alive == false) { //если монстр умер заканчиваем игру
				new InfoFrame("Вы победили монстра");
				return;
			}
			boolean monsterUseHeal = PlayFrame.readyMonster.autoHeal(); // монстр решает будет ли лечиться 
			String monsterUseHealMessage = " не использовал хилку";
			if (monsterUseHeal) { 
				monsterUseHealMessage = " использовал хилку";
				}
			int monsterDamage = PlayFrame.readyMonster.HitEnemy(PlayFrame.readyPlayer); //Монстр наносит урон с помощью метода HitEnemy из класса Entity и выводится окно с информацией о произошедшем
			new InfoFrame("Вы ударили монстра на: " + Integer.toString(playerDamage) + " хп, в свою очередь он" + monsterUseHealMessage + " и ударил вас на:" + Integer.toString(monsterDamage) + " хп");
			SwingUtilities.invokeLater(UpdateInfo); //обновляем лейблы
			if (PlayFrame.readyPlayer.alive == false) {
				new InfoFrame("Вы проиграли");
				return;
			}
			}
		else if (e.getSource().equals(takeHeal)) {
			
			if (PlayFrame.readyPlayer.Heal()){ //вызываем метод Heal класса Entity, в зависимости от результата выводим сообщение и обновляем данные лейблов с состоянием
				new InfoFrame("Вы полечились");
				SwingUtilities.invokeLater(UpdateInfo);
				
			} else if (PlayFrame.readyPlayer.numberOfHeals > 3){
				new InfoFrame("Закончились хилки");
				SwingUtilities.invokeLater(UpdateInfo);
			} else if (PlayFrame.readyPlayer.health == PlayFrame.readyPlayer.healthMax) {
				new InfoFrame("Здоровье полное");
			}
			
		}
		
	}
	
	
}

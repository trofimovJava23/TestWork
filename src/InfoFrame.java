import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


//Класс для вывода информационных окон
public class InfoFrame extends JFrame implements ActionListener  {
	private static final long serialVersionUID =1L;
	JLabel infoLabel;
	JButton okButton = new JButton("OK");
	
	public InfoFrame(String infoString) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		infoLabel = new JLabel(infoString);
		add(infoLabel);
		add(okButton);
		okButton.addActionListener(this);
		pack();
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		if ((!PlayFrame.readyPlayer.alive) |  (!PlayFrame.readyMonster.alive)) { //если кто-то умер закрываем программу после нажатия ОК
			System.exit(0);
		}
	}
	
}

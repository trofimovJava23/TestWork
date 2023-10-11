import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


//Класс для вывода ошибок
public class InfoFrame extends JFrame {
	private static final long serialVersionUID =1L;
	JLabel ErrorLabel;
	public InfoFrame(String ErrorString) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		ErrorLabel = new JLabel(ErrorString);
		add(ErrorLabel);
		pack();
		setVisible(true);
		
	}
	
}

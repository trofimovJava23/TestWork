import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorFrame extends JFrame {
	private static final long serialVersionUID =1L;
	JLabel ErrorLabel;
	public ErrorFrame(String ErrorString) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		ErrorLabel = new JLabel(ErrorString);
		add(ErrorLabel);
		pack();
		setSize(200, 100);
		setVisible(true);
		
	}
	
}
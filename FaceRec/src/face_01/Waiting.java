package face_01;

import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JLabel;import javax.swing.JOptionPane;

public class Waiting extends JDialog{
	private JLabel l4btt;

	public Waiting() {
		setTitle("PLEASE WAITING......");
		
		setLocationRelativeTo(null);		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(300,0);
	
		
	}
}

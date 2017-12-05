package face_01;

import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TemClassForTest {
	public static String s1;
	public static String s2;
	private static String filename;
	private static JFileChooser chooser;
	public static void main(String[] args) {
		chooser=new JFileChooser();
		FileNameExtensionFilter filer=new FileNameExtensionFilter("hinh anh", "jpg","tif","gif","png","bpm","jpeg");
		chooser.setFileFilter(filer);
		int retutnVal = chooser.showOpenDialog(null);
		if(retutnVal == JFileChooser.APPROVE_OPTION){
			filename=chooser.getSelectedFile().getAbsolutePath();
		}
		System.out.println(filename);
	}

}

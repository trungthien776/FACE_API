package face_01;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ImageInfomation extends JFrame {
	public ImageInfomation() {
		setTitle("Information Detection");
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		chucnang();
	}
public void chucnang(){
		
		//txa.setText(t);
		JPanel pnNorth=new JPanel();
		//pnNorth
		JPanel pnWest=new JPanel();
		 //BoxLayout boxLayout;
		
		BoxLayout box=new BoxLayout(pnWest, BoxLayout.Y_AXIS);
        pnWest.setLayout(box);
    	BoxLayout box1=new BoxLayout(pnNorth, BoxLayout.Y_AXIS);
        pnNorth.setLayout(box1);
        
        JPanel pnC=new JPanel();
        BoxLayout box2=new BoxLayout(pnC, BoxLayout.Y_AXIS);
        pnC.setLayout(box2);
        //pnWest.add
        int c=0;
		for(Image a: MyCanvas.listRectangle)
		{
			JLabel lblTop=new JLabel("Top: ");
			JTextField txtTop=new JTextField();
			txtTop.setText(String.valueOf(a.getTop()));
			
			JLabel lblLeft=new JLabel("Left: ");
			JTextField txtLeft=new JTextField();
			txtLeft.setText(String.valueOf(a.getLeft()));
			JLabel lblWidth=new JLabel("Width: ");
			JTextField txtWidth=new JTextField();
			txtWidth.setText(String.valueOf(a.getWidth()));
			
			JLabel lblHeight=new JLabel("Height: ");
			JTextField txtHeight=new JTextField();
			txtHeight.setText(String.valueOf(a.getHeight()));
			JLabel lblGen=new JLabel("Gender: ");
			JTextField txtGen=new JTextField();
			txtGen.setText(a.getGender());
			
			JLabel lbAge=new JLabel("Age");
			JTextField txtAge=new JTextField();
			txtAge.setText(String.valueOf(a.getAge()));
			c=c+1;
			JLabel lblFace=new JLabel("Face "+c);
			
			JPanel pn1=new JPanel();
			pn1.add(lblTop);
			pn1.add(txtTop);
			JPanel pn2=new JPanel();
			pn1.add(lblLeft);
			pn1.add(txtLeft);
			JPanel pn3=new JPanel();
			pn1.add(lblWidth);
			pn1.add(txtWidth);
			JPanel pn4=new JPanel();
			pn1.add(lblHeight);
			pn1.add(txtHeight);
			
			pn1.add(lbAge);
			pn1.add(txtAge);
			JPanel pn5=new JPanel();
			pn1.add(lblGen);
			pn1.add(txtGen);
			pnC.add(lblFace);
			pnC.add(pn1);
			pnC.add(pn2);
			pnC.add(pn3);
			pnC.add(pn4);
			pnC.add(pn5);
			
			txtAge.setEditable(false);
			txtGen.setEditable(false);
			
			 
		}

		add(pnC,BorderLayout.WEST);

	}


}

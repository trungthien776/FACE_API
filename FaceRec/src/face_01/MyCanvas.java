package face_01;



import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;  

public class MyCanvas extends Canvas{  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String pth="src/temp.jpg";
	private static File pth2=new File("src/temp.jpg");
	public static Vector<Image > listRectangle=new Vector<>();
	private BufferedImage insertImg;
	
	public static void RunApp(){

		try {
			ImageResizer.resize(MyProject.filenameOpenDetect_Face, pth, 1300, 600);
		} catch (IOException e) {
			e.printStackTrace();
		}
		listRectangle=Driver.Process(pth);
		System.out.println(listRectangle.size());
		if(listRectangle.size()==0)
		{
			JOptionPane.showMessageDialog(null, "Not found face or Internet not avalable! \n Please check the Internet and try again!");
			
		}
		
	}
	
	public static int RunApp2(){

		try {
			ImageResizer.resize(MyProject.filenameOpenDetect_Face, pth, 1300, 600);
		} catch (IOException e) {
			e.printStackTrace();
		}
		listRectangle=Driver.Process(pth);
		System.out.println(listRectangle.size());
		if(listRectangle.size()==0)
		{
			JOptionPane.showMessageDialog(null, "Not found face or Internet not avalable! \n Please check the Internet and try again!");
			return 0;
		}
		return 1;
	}
	
//	public  void paint(Graphics g) {  
//		Toolkit t=Toolkit.getDefaultToolkit(); 
//		java.awt.Image i=t.getImage(pth); 
//		g.drawImage(i, 0,0,this);
//		
//
//	}  
	public  void paint(Graphics g) {  
		super.paint(g);
		
		try {
			insertImg = ImageIO.read(pth2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(insertImg != null) {
			g.drawImage(insertImg, 0,0,this);
		}
		int count=1;
		for(Image b: listRectangle){
			g.drawString("FACE: "+count, b.getLeft(), b.getTop());
			g.drawString(b.getGender(), b.getLeft()-35, b.getTop()+10);
			g.drawString(String.valueOf(b.getAge()), b.getLeft()-15, b.getTop()+20);
			g.drawRect(b.getLeft(), b.getTop(), b.getWidth(), b.getHeight());
			
			g.drawString( b.getGlasses(), b.getLeft()+b.getWidth()+3, b.getTop()+60);
	    	 Double max=b.getContempt();
			 if(max<=b.getSurprise()){
				 max=b.getSurprise();
			 }
			  if(max<=b.getHappiness()){
				 max=b.getHappiness();
			 }
			  if(max<=b.getNeutral())
			 {
				 max=b.getNeutral();
			 }
			  if(max<=b.getSadness())
			 {
				 max=b.getSadness();
			 }
			  if(max<=b.getDisgust())
			 {
				 max=b.getDisgust();
			 }
			  if(max<=b.getAnger())
			 {
				 max=b.getAnger();
			 }
			  if(max<=b.getFaer())
			 {
				 max=b.getFaer();
			 }
	 
			 if(max==b.getContempt())
				g.drawString( "Contempt", b.getLeft()+b.getWidth()+3, b.getTop()+80);
			else if(max==b.getSurprise())
				g.drawString( "Surprise", b.getLeft()+b.getWidth()+3, b.getTop()+80);
			else if(max==b.getHappiness())
				g.drawString( "Happiness", b.getLeft()+b.getWidth()+3, b.getTop()+80);
			else if(max==b.getNeutral())
				g.drawString( "Neutral", b.getLeft()+b.getWidth()+3, b.getTop()+80);
			else if(max==b.getSadness())
				g.drawString( "Sadness", b.getLeft()+b.getWidth()+3, b.getTop()+80);
			else if(max==b.getDisgust())
				g.drawString( "Disgust", b.getLeft()+b.getWidth()+3, b.getTop()+80);
			else if(max==b.getAnger())
				g.drawString( "Anger", b.getLeft()+b.getWidth()+3, b.getTop()+80);
			else if(max==b.getFaer())
				g.drawString( "Faer", b.getLeft()+b.getWidth()+3, b.getTop()+80);
			   
			
			setForeground(Color.RED);
			
			count++;
		}

	}
}   

package face_01;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.opencv.core.Core;

import group5.CreatePersonGroup;
import group5.JavaSampleAddFace;
import group5.JavaSampleCreatePerson;
import group5.JavaSampleGetPersonName;
import group5.JavaSampleIdentify;
import group5.TrainGroup;

public class MyProject extends JFrame implements ActionListener{

	/**
	 * 
	 */


	/**
	 * @author TRUONG TRUNG THIEN
	 * @author CAC THAM SO SU DUNG
	 * @throws IOException
	 * @param tabbedPane bao gồm face detection và face verification
	 * @param panelDetect là panelChứa tính năng detect face và chứa panelSouthButton ở SOUTH
	 * @param panelCompare là panel dùng để verify 2 ảnh
	 * 
	 * @category panelDetect là một panel có BorderLayout và chứa panel button ở SOUTH 
	 * @param panelButton chứa 4 button dùng absolutlayout
	 */
	ImageIcon loading = new ImageIcon("lib/loading.gif");
	private static final long serialVersionUID = 1L;
	private JPanel panelDetect;
	private JPanel panelCompare;
	//-------------------------------------------
	private JButton buttonInfo;
	private JButton buttonImport;
	private JButton buttonWebcamt;
	private JButton buttonExit;
	private JPanel panelButton;
	//-------------------------------------
	private JButton buttonBrowse1;
	private JButton buttonBrowse2;
	private JPanel panelSouthCompare;
	private JButton buttonCompare;
	private JPanel pEast;
	private JPanel pWest;
	private JLabel lbeast;
	private JLabel lbex;
	private String filenameOpen2;
	private String filenameOpen;
	private JFileChooser choose;
	private JFileChooser choose2;
	MyCanvas m=null;
	//------------------------------------------------------
	private JFileChooser chooseImport;
	public static String filenameOpenDetect_Face;
	private JLabel lblimport;
	private JLabel lbload;
	
	//-----------------------------------------------------------
	private JPanel panelIdentify;
	private JPanel pnSouthIdentify;
	private JButton buttonCreateGroup;
	private JButton buttonCreatePerson;
	private JButton buttonAddPersonFace;
	private JButton buttonTrain;
	private JButton buttonIdentify;
	private String filenameIdentify;
	private JFileChooser chooseIdentify;
	private String nameofPerson;
	private String name;
	private String name2;
	private JPanel pWestIdentify;
	private JLabel lbImageIdentify;
	private JTextArea textAreaValue;
	public static String GroupId;
	public static String PersonID;
	public static String PersonName;
	
	//---------------------------------------------
	public MyProject() throws IOException {
		setTitle("FACE APPLYCATION INTERFACE");
		setSize(1300, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setupGUI();
	}


	private void setupGUI() throws IOException {

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Verdana", Font.BOLD, 14));
		tabbedPane.setForeground(Color.DARK_GRAY);;
		tabbedPane.setBackground(Color.GREEN);

		add(tabbedPane);
		//----------------------------
		/*
		 * COMPONENT trong tabDETECT
		 */
		panelDetect=new JPanel();
		tabbedPane.add(panelDetect, "DETECTION");
		panelDetect.setLayout(new BorderLayout());
		panelDetect.add(lblimport = new JLabel("Click DETECT to import image"),BorderLayout.CENTER);
		lblimport.setFont(new Font("Verdana", Font.BOLD, 25));
		lblimport.setHorizontalAlignment(JLabel.CENTER);
		panelDetect.add(panelButton=new JPanel(),BorderLayout.SOUTH);
		panelButton.setPreferredSize(new Dimension(1000, 50));
		panelButton.setLayout(null);
		panelButton.add(buttonInfo=new JButton("INFO"));
		panelButton.add(buttonImport=new JButton("DETECT"));
		panelButton.add(buttonWebcamt=new JButton("WEBCAM"));
		panelButton.add(buttonExit=new JButton("EXIT"));
		panelButton.setBackground(Color.BLUE);
		buttonInfo.setBounds(200, 17, 100, 25);
		buttonImport.setBounds(400, 17, 100, 25);
		buttonWebcamt.setBounds(600, 17, 100, 25);
		buttonExit.setBounds(800, 17, 100, 25);
		buttonImport.setForeground(Color.BLUE);
		//////----------------------------------------
		/*
		 * Component trong tab Verify
		 */
		panelCompare=new JPanel();
		tabbedPane.add(panelCompare, "VERIFICATION");
		panelCompare.setLayout(new BorderLayout());
		panelSouthCompare=new JPanel();
		panelSouthCompare.add(buttonBrowse1=new JButton("Browse"));
		panelSouthCompare.add(buttonCompare=new JButton("EXECUTE"));
		panelSouthCompare.add(buttonBrowse2=new JButton("Browse"));
		panelCompare.add(panelSouthCompare, BorderLayout.SOUTH );
		panelSouthCompare.setBackground(Color.BLUE);
		//
		panelCompare.add(pWest=new JPanel(),BorderLayout.WEST);
		pWest.add(lbex=new JLabel());
		pWest.setPreferredSize(new Dimension(650, 600));

		//
		panelCompare.add(pEast=new JPanel(),BorderLayout.EAST);
		pEast.add(lbeast=new JLabel());
		pEast.setPreferredSize(new Dimension(650, 600));
//-----------------------------------------------------------------------------------
		/*
		 * Component trong tab IDENTIFY
		 * 
		 */
		panelIdentify=new JPanel();
		tabbedPane.add(panelIdentify,"IDENTIFICATION");
		
		panelIdentify.setLayout(new BorderLayout());
		panelIdentify.add(pnSouthIdentify=new JPanel(), BorderLayout.SOUTH);
		pnSouthIdentify.setBackground(Color.blue);
		
		pnSouthIdentify.add(buttonCreateGroup=new JButton("CREATE GROUP"));
		pnSouthIdentify.add(buttonCreatePerson=new JButton("CREATE PERSON "));
		pnSouthIdentify.add(buttonAddPersonFace=new JButton("ADD FACE "));
		pnSouthIdentify.add(buttonTrain=new JButton("TRAIN GROUP "));
		pnSouthIdentify.add(buttonIdentify=new JButton("IDENTIFY NAME "));
		
		panelIdentify.add(pWestIdentify=new JPanel(),BorderLayout.WEST);
		pWestIdentify.add(lbImageIdentify=new JLabel());
		pWestIdentify.setPreferredSize(new Dimension(650, 600));
		
		panelIdentify.add(textAreaValue=new JTextArea(),BorderLayout.EAST);
		textAreaValue.setPreferredSize(new Dimension(500, 600));
		textAreaValue.setFont(new Font("Arial", Font.BOLD, 18));
		textAreaValue.setLineWrap(true);
		textAreaValue.setEditable(false);

		//---------------- BUTTON--------------------------------------------------------------------------------------------------------------
		/**
		 *  Add button for action listener
		 */

		buttonBrowse1.addActionListener(this);
		buttonBrowse2.addActionListener(this);
		buttonCompare.addActionListener(this);
		
		buttonExit.addActionListener(this);
		buttonImport.addActionListener(this);
		buttonWebcamt.addActionListener(this);
		buttonInfo.addActionListener(this);
		
		buttonCreateGroup.addActionListener(this);
		buttonCreatePerson.addActionListener(this);
		buttonAddPersonFace.addActionListener(this);
		buttonIdentify.addActionListener(this);
		buttonTrain.addActionListener(this);
		
		
		/*
		 *  Clock button prevent User autoClick
		 */
		UnLockVerify(false);

	}

	private void UnLockVerify(boolean b) {
		buttonCompare.setEnabled(b);
	}


	//---------------RESIZE AND SET IMAGE INTO PANEL----------------------------------------------------------------------------
	private void setImage(JLabel label, String filename){
		lblimport.removeAll();
		try {
			BufferedImage image = ImageIO.read(new File(filename));
			image=ImageResizer.resize(filename, 650, 600);

			ImageIcon icon = new ImageIcon(image);

			label.setIcon(icon);

		} catch (IOException e) {
			System.err.println("khong the dua anh len");
		}catch (NullPointerException e) {
			System.err.println("khong mo file!");

		}
	}

	// -------------- ACTIONPERFORMED-------------------------------
	
	/**
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * @param buttonBrows21 và  buttonBrowse2 cho phép mở 2 ảnh từ đường dẫn người dùng chỉ định
	 * @param buttonCompare: thao tác verify và trả về kết quả 
	 * @param buttonImport: Detect face
	 * @param buttonInfo
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		/*
		//-----------------Handling TAB2------------------------------------------------------------------------------------------------------------------------------------
		 * 
		 */
		if(o.equals(buttonBrowse1))
		{
			choose=new JFileChooser();
			FileNameExtensionFilter filer=new FileNameExtensionFilter("hinh anh", "jpg","tif","gif","png","bpm");
			choose.setFileFilter(filer);
			int retutnVal = choose.showOpenDialog(this);
			if(retutnVal == JFileChooser.APPROVE_OPTION){
				filenameOpen=choose.getSelectedFile().getAbsolutePath();
				setImage(lbex, filenameOpen);
			}
		}else if(o.equals(buttonBrowse2))
		{
			choose2=new JFileChooser();
			FileNameExtensionFilter filer=new FileNameExtensionFilter("hinh anh", "jpg","tif","gif","png","bpm","jpeg");
			choose2.setFileFilter(filer);
			int retutnVal = choose2.showOpenDialog(this);
			if(retutnVal == JFileChooser.APPROVE_OPTION){
				filenameOpen2=choose2.getSelectedFile().getAbsolutePath();
				setImage(lbeast, filenameOpen2);
				UnLockVerify(true);
			}
		}else if(o.equals(buttonCompare))
		{
			Waiting wt=new Waiting();
			wt.setVisible(true);
			new Verify();
			String gt=Verify.Verify_request(filenameOpen, filenameOpen2);
			wt.setVisible(false);


			try{
				//			JOptionPane.showMessageDialog(null, gt);
				//			System.out.println(gt);
				String g2=gt.substring(15, 16);
				if(g2.equals("f")){
					JOptionPane.showMessageDialog(null, "Not match!");
				}else{
					String g3=gt.substring(33,37);
					System.out.println(g3);
					Double d=Double.parseDouble(g3)*100;
					JOptionPane.showMessageDialog(null, "Same person! \n With:"+String.valueOf(d)+"%");
				}
			}catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, "This is a person!");
			}


			//----------------------- TAB1-------------------------------------------------------------------------------------------------------------------------------
		}else if(o.equals(buttonExit)){
			String message="are you sure?";
			String title="WARNING!";
			int rel=JOptionPane.showConfirmDialog(null, message,title,JOptionPane.YES_NO_OPTION);
			if(rel==JOptionPane.YES_OPTION)
			{
					System.exit(1);
			}
		}else if(o.equals(buttonImport)){
			lblimport.setText("Please wait...");

			panelButton.add(lbload=new JLabel("loading...."));

			lbload.setFont(new Font("Arial", Font.BOLD, 16));
			lbload.setForeground(Color.YELLOW);
			lbload.setBounds(1000, 17, 100, 25);
			chooseImport=new JFileChooser();
			FileNameExtensionFilter filer=new FileNameExtensionFilter("gif","jpeg");
			chooseImport.setFileFilter(filer);
			int retutnVal = chooseImport.showOpenDialog(this);
			if(retutnVal == JFileChooser.APPROVE_OPTION){
				filenameOpenDetect_Face=chooseImport.getSelectedFile().getAbsolutePath();
				System.out.println(filenameOpenDetect_Face);

				int val=MyCanvas.RunApp2();
				if(val==1)
				{
					m=new MyCanvas();
					m.setBounds(0, 25, 1300, 585);
					getContentPane().add(m);

				}
			}else
			{
				lblimport.setText("Click DETECT to import image");
			}
			panelButton.remove(lbload);
		} else if(o.equals(buttonInfo)){
			new ImageInfomation().setVisible(true);
		}else if(o.equals(buttonWebcamt)){
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			new SnapShot().setVisible(true);
		}

	//---------------- TAB3-------------------------------------------------------	----------------------------------------------------------------------------
		else if(o.equals(buttonCreateGroup)){
			GroupId=JOptionPane.showInputDialog("Enter GroupID:");
			String describe=JOptionPane.showInputDialog("Enter Description:");
			CreatePersonGroup.CreatePresonGroup(GroupId, describe);
		}else if(o.equals(buttonCreatePerson)){
			PersonName=JOptionPane.showInputDialog("Create Person at group: "+GroupId+"\n Enter PersonName:");
			String personInfo=JOptionPane.showInputDialog("Describe person:");
			PersonID=JavaSampleCreatePerson.CreatePerson(GroupId, PersonName, personInfo);
			System.out.println(PersonID);
		}else if(o.equals(buttonAddPersonFace)){
			JavaSampleAddFace.AddFace(GroupId, PersonID);
		}else if(o.equals(buttonTrain)){
			TrainGroup.Train(GroupId);
		}else if(o.equals(buttonIdentify)){
			chooseIdentify = new JFileChooser();
			FileNameExtensionFilter filer=new FileNameExtensionFilter("Image", "jpg","tif","gif","png","bpm","jpeg","psd");
			chooseIdentify.setFileFilter(filer);
			int retutnVal = chooseIdentify.showOpenDialog(this);
			if(retutnVal == JFileChooser.APPROVE_OPTION){
				filenameIdentify=chooseIdentify.getSelectedFile().getAbsolutePath();
				setImage(lbImageIdentify, filenameIdentify);
			}
			
			
			nameofPerson=JavaSampleIdentify.Identify(filenameIdentify, GroupId);
			System.out.println(nameofPerson);
			try{
			nameofPerson=nameofPerson.substring(77, 113);
			System.out.println(nameofPerson);
			name=JavaSampleGetPersonName.getPersonName(nameofPerson, GroupId);
//			textAreaValue.setText(name);
			
			
			if (name.charAt(0) == '[') {
                JSONArray jsonArray = new JSONArray(name);
                System.out.println(jsonArray.toString(2));
            }
            else if (name.charAt(0) == '{') {
                JSONObject jsonObject = new JSONObject(name);
                System.out.println(jsonObject.toString(2));
                name2=jsonObject.getString("name");
            } else {
                
            }
			System.out.println(name);
			textAreaValue.setText(name2);
			}catch (Exception e2) {
				textAreaValue.setText("Don't know that person!");
			}
		}
	}
//77 113

}

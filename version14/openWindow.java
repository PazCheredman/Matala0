package version14;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class openWindow {

	private JFrame frame;
	private JButton Algorithm;
	private JButton filter;
	private JButton createFiles;
	private JTextField enterPathWiggle;
	private mainRun tableCsv= new mainRun();
	private mainRun tableKml= new mainRun();
	private JLabel lblPleaseEnterPath_1;
	private JTextField enterPathCsvKml;
	private boolean ok1=false,ok2=false,result=false;
	private JButton btnNext;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					openWindow window = new openWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public openWindow()  {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 815, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblWelcomeToOur = new JLabel("Welcome to our GPS program");
		lblWelcomeToOur.setForeground(Color.RED);
		lblWelcomeToOur.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblWelcomeToOur.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToOur.setBounds(122, 16, 508, 51);
		frame.getContentPane().add(lblWelcomeToOur);
		
		enterPathWiggle = new JTextField();
		enterPathWiggle.setBounds(141, 120, 461, 42);
		frame.getContentPane().add(enterPathWiggle);
		enterPathWiggle.setColumns(10);
				
		enterPathCsvKml = new JTextField();
		enterPathCsvKml.setColumns(10);
		enterPathCsvKml.setBounds(141, 230, 461, 42);
		frame.getContentPane().add(enterPathCsvKml);
		
		//databases data = new databases(enterPathWiggle.getText(),enterPathCsvKml.getText());
		
		JLabel lblPleaseEnterPath = new JLabel("please enter path of folder that contains wiggle wifi application files:");
		lblPleaseEnterPath.setForeground(Color.RED);
		lblPleaseEnterPath.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseEnterPath.setBounds(72, 70, 735, 36);
		frame.getContentPane().add(lblPleaseEnterPath);
		
		lblPleaseEnterPath_1 = new JLabel("please enter path of other folder that you want to put the csv and kml files in it");
		lblPleaseEnterPath_1.setForeground(Color.RED);
		lblPleaseEnterPath_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseEnterPath_1.setBounds(40, 178, 735, 36);
		frame.getContentPane().add(lblPleaseEnterPath_1);
		
		btnNext = new JButton("next");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result= tableCsv.okay(enterPathCsvKml.getText()+"\\"+ "gmon.csv");
				try{
					if(!enterPathWiggle.getText().isEmpty() && !enterPathCsvKml.getText().isEmpty() && result){
						tableCsv.init(enterPathWiggle.getText(), enterPathCsvKml.getText(), "gmon.csv");
						nextFrame next= new nextFrame();
						tableKml.initiliaze(enterPathCsvKml.getText()+"\\", "gmon.csv");
						next.setWigPath(enterPathWiggle.getText());
						next.setCsvPath(enterPathCsvKml.getText()+"\\gmon.csv");
						frame.dispose();
						next.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "please enter paths to text boxes above");

					}
					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input ok1,ok2 buttons");
				}
				
			}
		});
		btnNext.setBounds(273, 288, 142, 36);
		frame.getContentPane().add(btnNext);
	}

	public JTextField getEnterPathCsvKml() {
		return enterPathCsvKml;
	}
	
	public String getCsvKmlPath() {
		return enterPathCsvKml.getText();
	}
	
	public JTextField getEnterPath() {
		return enterPathWiggle;
	}
	
	public mainRun getCsvTable(){
		return tableCsv;
	}
	
	public mainRun getKmlTable() {
		return tableKml;
	}
	
	public String getPathCsvKml() {
		return tableCsv.getKmlPath();
	}
		
	public JFrame getFrame(){
		return frame;
	}
}

package version14;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.sun.istack.FragmentContentHandler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

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
	private JButton btnOk;
	private JButton button;
	private boolean ok1=false,ok2=false;
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
		frame.setBounds(100, 100, 885, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblWelcomeToOur = new JLabel("Welcome to our GPS program");
		lblWelcomeToOur.setForeground(Color.RED);
		lblWelcomeToOur.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblWelcomeToOur.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToOur.setBounds(131, 45, 508, 51);
		frame.getContentPane().add(lblWelcomeToOur);
		
		enterPathWiggle = new JTextField();
		enterPathWiggle.setBounds(131, 149, 461, 42);
		frame.getContentPane().add(enterPathWiggle);
		enterPathWiggle.setColumns(10);
		
		enterPathCsvKml = new JTextField();
		enterPathCsvKml.setColumns(10);
		enterPathCsvKml.setBounds(131, 259, 461, 42);
		frame.getContentPane().add(enterPathCsvKml);

		JLabel lblPleaseEnterPath = new JLabel("please enter path of folder that contains wiggle wifi application files:");
		lblPleaseEnterPath.setForeground(Color.RED);
		lblPleaseEnterPath.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseEnterPath.setBounds(98, 97, 735, 36);
		frame.getContentPane().add(lblPleaseEnterPath);
		
		lblPleaseEnterPath_1 = new JLabel("please enter path of other folder that you want to put the csv and kml files in it");
		lblPleaseEnterPath_1.setForeground(Color.RED);
		lblPleaseEnterPath_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseEnterPath_1.setBounds(72, 207, 735, 36);
		frame.getContentPane().add(lblPleaseEnterPath_1);
		
		btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path;
				try{
					if(!enterPathWiggle.getText().isEmpty()){
						path=enterPathWiggle.getText();
						ok1=true;
				 //	JOptionPane.showMessageDialog(null, "ok input of wiggle button");
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of wiggle button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of wiggle button");
				}
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnOk.setBounds(607, 152, 115, 29);
		frame.getContentPane().add(btnOk);
		
		button = new JButton("ok");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path;
				try{
					if(!enterPathCsvKml.getText().isEmpty()){
						path=enterPathCsvKml.getText();
						ok2=true;
					tableCsv.init(enterPathWiggle.getText(), enterPathCsvKml.getText(), "gmon.csv");
					// JOptionPane.showMessageDialog(null, "ok input of CsvKml button");
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of CsvKml button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of CsvKml button");				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button.setBounds(607, 262, 115, 29);
		frame.getContentPane().add(button);
		
		btnNext = new JButton("next");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(ok1 && ok2){
						nextFrame next= new nextFrame();
						tableKml.initiliaze(enterPathCsvKml.getText(), "gmon.csv");
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
		btnNext.setBounds(303, 317, 142, 36);
		frame.getContentPane().add(btnNext);
	}

	public JTextField getEnterPathCsvKml() {
		return enterPathCsvKml;
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
		return enterPathCsvKml.getText();
	}
	
	
	
}

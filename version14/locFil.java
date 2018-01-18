package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class locFil extends JFrame {

	private JPanel contentPane;
	private JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5;
	private String csvPath;
	private String wigglePath;
	private JButton btnNext;
	private boolean ok_1=false, ok_2=false, ok_3=false, ok_4=false, ok_5=false, ok_6=false;
	private moreFil more;
	public boolean notFilter = false;
	public String locCsv, locNotCsv;

	public void setMore(moreFil more) {
		this.more = more;
	}
	
	public String getLocCsv() {
		return locCsv;
	}

	public void setLocCsv(String locCsv) {
		this.locCsv = locCsv;
	}

	public String getLocNotCsv() {
		return locNotCsv;
	}

	public void setLocNotCsv(String locNotCsv) {
		this.locNotCsv = locNotCsv;
	}

	public void setnotFilter(boolean dataPath) {
		this.notFilter = dataPath;
	}

	public String getCsvPath() {
		return csvPath;
	}

	public void setCsvPath(String dataPath) {
		this.csvPath = dataPath;
	}

	public String getWigPath() {
		return wigglePath;
	}

	public void setWigPath(String wigPath) {
		this.wigglePath = wigPath;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					locFil frame = new locFil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public locFil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterMaxlat = new JLabel("enter maxLat");
		lblEnterMaxlat.setBounds(297, 19, 205, 20);
		contentPane.add(lblEnterMaxlat);

		JLabel lblEnterMaxlon = new JLabel("enter maxLon");
		lblEnterMaxlon.setBounds(297, 55, 139, 20);
		contentPane.add(lblEnterMaxlon);

		JLabel lblEnterMaxalt = new JLabel("enter maxAlt");
		lblEnterMaxalt.setBounds(297, 88, 139, 20);
		contentPane.add(lblEnterMaxalt);

		JLabel lblEnterMinlat = new JLabel("enter minLat");
		lblEnterMinlat.setBounds(15, 19, 139, 20);
		contentPane.add(lblEnterMinlat);

		JLabel lblEnterMinlon = new JLabel("enter minLon");
		lblEnterMinlon.setBounds(15, 52, 139, 20);
		contentPane.add(lblEnterMinlon);

		JLabel lblEnterMinalt = new JLabel("enter minAlt");
		lblEnterMinalt.setBounds(15, 88, 110, 20);
		contentPane.add(lblEnterMinalt);

		textField = new JTextField();
		textField.setBounds(119, 13, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(119, 52, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(119, 90, 146, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(406, 16, 146, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(406, 55, 146, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(406, 90, 146, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		btnNext = new JButton("next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty() && 
							!textField_2.getText().isEmpty() && !textField_3.getText().isEmpty() &&
							!textField_4.getText().isEmpty() && !textField_5.getText().isEmpty()){
						main m= new main();
						if(!notFilter){
							m.location(csvPath, textField.getText(), textField_1.getText(), textField_2.getText(), 
									textField_3.getText(), textField_4.getText(), textField_5.getText(), false);
							
							String sub =csvPath.substring(0, csvPath.length()-9);
							testKml kmlLoc= new testKml();	
							kmlLoc.readCsvFile(sub, "locFil.csv");
							setLocCsv(sub + "/locFil.csv");
							contentPane.hide();
							more.nextWindow(sub + "/locFil.csv", 4);
						}
						else{
							m.location(csvPath, textField.getText(), textField_1.getText(), textField_2.getText(), 
									textField_3.getText(), textField_4.getText(), textField_5.getText(), true);
							String sub =csvPath.substring(0, csvPath.length()-9);
							testKml kmlLoc= new testKml();	
							kmlLoc.readCsvFile(sub, "locFilNOT.csv");
							setLocNotCsv(sub + "/locFilNOT.csv");
							contentPane.hide();
							more.nextWindow(sub + "/locFilNOT.csv", 4);
						}
						JOptionPane.showMessageDialog(null, "go to the folder to see output files");
						contentPane.hide();
					}
					else{
						JOptionPane.showMessageDialog(null, " input of textField button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of textField button");				}
			}

		});
		btnNext.setBounds(213, 132, 115, 29);
		contentPane.add(btnNext);
	}

}

package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class idFil extends JFrame {

	private JPanel contentPane;
	private String csvPath;
	private String wigglePath;
	private JTextField textField;
	private moreFil more;
	public boolean notFilter = false;
	public String idCsv, idNotCsv;
	
	public void setMore(moreFil more) {
		this.more = more;
	}

	public String getIdCsv() {
		return idCsv;
	}

	public void setIdCsv(String idCsv) {
		this.idCsv = idCsv;
	}

	public String getIdNotCsv() {
		return idNotCsv;
	}

	public void setIdNotCsv(String idNotCsv) {
		this.idNotCsv = idNotCsv;
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
					idFil frame = new idFil();
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
	public idFil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterId = new JLabel("enter id:");
		lblEnterId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEnterId.setBounds(30, 42, 125, 18);
		contentPane.add(lblEnterId);

		textField = new JTextField();
		textField.setBounds(135, 41, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id;
				try{
					if(!textField.getText().isEmpty()){
						id=textField.getText();
						main m= new main();
						if(!notFilter){
							String sub =csvPath.substring(0, csvPath.length()-9);
							m.id(csvPath, id, false);
							testKml kmlId= new testKml();	
							kmlId.readCsvFile(sub, "id.csv");
							setIdCsv(sub + "/id.csv");
							contentPane.hide();
							more.nextWindow(sub + "/id.csv", 3);
						}
						else{
							String sub =csvPath.substring(0, csvPath.length()-9);
							m.id(csvPath, id, true);
							testKml kmlId= new testKml();	
							kmlId.readCsvFile(sub, "idNOT.csv");
							setIdNotCsv(sub + "/idNOT.csv");
							contentPane.hide();
							more.nextWindow(sub + "/idNOT.csv", 3);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, " input of textField button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of textField button");				}
			}
		});
		btnNewButton.setBounds(79, 76, 115, 29);
		contentPane.add(btnNewButton);
	}

}

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
	private JButton ok1, ok2,ok3,ok4,ok5,ok6;
	private JButton btnNext;
	private boolean ok_1=false, ok_2=false, ok_3=false, ok_4=false, ok_5=false, ok_6=false;
	
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
		setBounds(100, 100, 788, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterMaxlat = new JLabel("enter maxLat");
		lblEnterMaxlat.setBounds(391, 19, 205, 20);
		contentPane.add(lblEnterMaxlat);
		
		JLabel lblEnterMaxlon = new JLabel("enter maxLon");
		lblEnterMaxlon.setBounds(390, 52, 139, 20);
		contentPane.add(lblEnterMaxlon);
		
		JLabel lblEnterMaxalt = new JLabel("enter maxAlt");
		lblEnterMaxalt.setBounds(400, 88, 139, 20);
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
		textField_3.setBounds(502, 13, 146, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(502, 49, 146, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(502, 85, 146, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		ok1 = new JButton("ok");
		ok1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty()){
					ok_1=true;
				}
			}
		});
		ok1.setBounds(280, 12, 58, 29);
		contentPane.add(ok1);
		
		ok2 = new JButton("ok");
		ok2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_1.getText().isEmpty()){
					ok_2=true;
				}
			}
		});
		ok2.setBounds(280, 51, 58, 29);
		contentPane.add(ok2);
		
		ok3 = new JButton("ok");
		ok3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_2.getText().isEmpty()){
					ok_3=true;
				}
			}
		});
		ok3.setBounds(280, 84, 58, 29);
		contentPane.add(ok3);
		
		ok4 = new JButton("ok");
		ok4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_3.getText().isEmpty()){
					ok_4=true;
				}
			}
		});
		ok4.setBounds(670, 10, 58, 29);
		contentPane.add(ok4);
		
		ok5 = new JButton("ok");
		ok5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_4.getText().isEmpty()){
					ok_5=true;
				}
			}
		});
		ok5.setBounds(670, 48, 58, 29);
		contentPane.add(ok5);
		
		ok6 = new JButton("ok");
		ok6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_5.getText().isEmpty()){
					ok_6=true;
				}
			}
		});
		ok6.setBounds(670, 84, 58, 29);
		contentPane.add(ok6);
		
		btnNext = new JButton("next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(ok_1 && ok_2 && ok_3 && ok_4 && ok_5 && ok_6){
						main m= new main();
						m.location(csvPath, textField.getText(), textField_1.getText(), textField_2.getText(), 
								textField_3.getText(), textField_4.getText(), textField_5.getText());
						JOptionPane.showMessageDialog(null, "go to the folder to see output files");
						contentPane.hide();
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of textField button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of textField button");				}
			}
				
		});
		btnNext.setBounds(326, 164, 115, 29);
		contentPane.add(btnNext);
	}

}

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
						m.id(csvPath, id);
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of textField button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of textField button");				}
			}
		});
		btnNewButton.setBounds(79, 76, 115, 29);
		contentPane.add(btnNewButton);
	}

}

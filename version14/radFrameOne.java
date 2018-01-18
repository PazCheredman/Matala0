package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class radFrameOne extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					radFrameOne frame = new radFrameOne();
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
	public radFrameOne() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(186, 27, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterLat = new JLabel("enter lat");
		lblEnterLat.setBounds(49, 30, 69, 20);
		contentPane.add(lblEnterLat);
		
		JLabel lblEnterLon = new JLabel("enter lon");
		lblEnterLon.setBounds(49, 66, 69, 20);
		contentPane.add(lblEnterLon);
		
		JLabel lblEnterAlt = new JLabel("enter alt");
		lblEnterAlt.setBounds(49, 102, 69, 20);
		contentPane.add(lblEnterAlt);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 69, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(186, 99, 146, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEnterRadious = new JLabel("enter radious");
		lblEnterRadious.setBounds(49, 140, 122, 20);
		contentPane.add(lblEnterRadious);
		
		textField_3 = new JTextField();
		textField_3.setBounds(186, 137, 146, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}

}

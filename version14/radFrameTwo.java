package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class radFrameTwo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					radFrameTwo frame = new radFrameTwo();
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
	public radFrameTwo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterMaxlat = new JLabel("enter maxLat");
		lblEnterMaxlat.setBounds(15, 132, 205, 20);
		contentPane.add(lblEnterMaxlat);
		
		JLabel lblEnterMaxlon = new JLabel("enter maxLon");
		lblEnterMaxlon.setBounds(15, 168, 139, 20);
		contentPane.add(lblEnterMaxlon);
		
		JLabel lblEnterMaxalt = new JLabel("enter maxAlt");
		lblEnterMaxalt.setBounds(15, 205, 139, 20);
		contentPane.add(lblEnterMaxalt);
		
		JLabel lblEnterMinlat = new JLabel("enter minLat");
		lblEnterMinlat.setBounds(15, 16, 139, 20);
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
		textField_3.setBounds(119, 129, 146, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(119, 168, 146, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(119, 202, 146, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}

}

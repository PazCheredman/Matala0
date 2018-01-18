package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class radFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					radFrame frame = new radFrame();
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
	public radFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseChooseWhich = new JLabel("please choose which way you want to present your data base: one or two");
		lblPleaseChooseWhich.setBounds(15, 16, 705, 20);
		contentPane.add(lblPleaseChooseWhich);
		
		JLabel lblInOneYou = new JLabel("in one you need to enter lat,lon,alt,radious and it will show you all the wifi networks in the range of the radious entered.");
		lblInOneYou.setBounds(15, 52, 952, 20);
		contentPane.add(lblInOneYou);
		
		JLabel lblInTwoYou = new JLabel("in two you need to enter maximus and minimus values to lat, lon, alt and it will show you all the wifi networks in the range");
		lblInTwoYou.setBounds(15, 77, 952, 44);
		contentPane.add(lblInTwoYou);
		
		JButton btnOne = new JButton("one");
		btnOne.setBounds(101, 137, 115, 29);
		contentPane.add(btnOne);
		
		JButton btnTwo = new JButton("two");
		btnTwo.setBounds(286, 137, 115, 29);
		contentPane.add(btnTwo);
	}

}

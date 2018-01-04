package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class filters extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					filters frame = new filters();
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
	public filters() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseChooseWhich = new JLabel("please choose which filter you want to use.");
		lblPleaseChooseWhich.setBounds(130, 54, 641, 20);
		contentPane.add(lblPleaseChooseWhich);
		
		JLabel lblIfYouWant = new JLabel("if you want to filter by more than one filter, please choose the option \"more than one\"");
		lblIfYouWant.setBounds(130, 85, 633, 20);
		contentPane.add(lblIfYouWant);
		
		JButton btnRadious = new JButton("Radious");
		btnRadious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnRadious.setBounds(49, 181, 115, 29);
		contentPane.add(btnRadious);
		
		JButton btnTime = new JButton("Time");
		btnTime.setBounds(334, 181, 115, 29);
		contentPane.add(btnTime);
		
		JButton btnLocation = new JButton("Location");
		btnLocation.setBounds(476, 181, 115, 29);
		contentPane.add(btnLocation);
		
		JButton btnMoreThanOne = new JButton("more than one");
		btnMoreThanOne.setBounds(622, 181, 196, 29);
		contentPane.add(btnMoreThanOne);
		
		JButton btnId = new JButton("ID");
		btnId.setBounds(191, 181, 115, 29);
		contentPane.add(btnId);
	}

}

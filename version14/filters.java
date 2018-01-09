package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Font;

public class filters extends JFrame {

	private boolean ok=false;
	private JPanel contentPane;
	private String csvPath;
	private String wigglePath;

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
		setBounds(100, 100, 1041, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPleaseChooseWhich = new JLabel("please choose which filter you want to use.");
		lblPleaseChooseWhich.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblPleaseChooseWhich.setBounds(49, 39, 641, 20);
		contentPane.add(lblPleaseChooseWhich);

		JLabel lblIfYouWant = new JLabel("if you want to filter by more than one filter, please choose the option \"more than one\"");
		lblIfYouWant.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblIfYouWant.setBounds(49, 75, 878, 53);
		contentPane.add(lblIfYouWant);

		JButton btnRadious = new JButton("Radious");
		btnRadious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


			}
		});
		btnRadious.setBounds(49, 181, 115, 29);
		contentPane.add(btnRadious);

		JButton btnTime = new JButton("Time");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeFil tim= new timeFil();
				tim.setCsvPath(csvPath);
				tim.setWigPath(wigglePath);
				contentPane.hide();
				tim.setVisible(true);
			}
		});
		btnTime.setBounds(334, 181, 115, 29);
		contentPane.add(btnTime);

		JButton btnLocation = new JButton("Location");
		btnLocation.setBounds(476, 181, 115, 29);
		contentPane.add(btnLocation);

		JButton btnMoreThanOne = new JButton("more than one");
		btnMoreThanOne.setBounds(622, 181, 196, 29);
		contentPane.add(btnMoreThanOne);

		JButton btnId = new JButton("ID");
		btnId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idFil idf= new idFil();
				idf.setCsvPath(csvPath);
				idf.setWigPath(wigglePath);
				contentPane.hide();
				idf.setVisible(true);
			}
		});
		btnId.setBounds(191, 181, 115, 29);
		contentPane.add(btnId);
	}

}

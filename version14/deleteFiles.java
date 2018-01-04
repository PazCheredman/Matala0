package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import java.awt.Color;

public class deleteFiles extends JFrame {

	private JPanel contentPane;
	private openWindow op= new openWindow();
	private mainRun tableCsv= op.getCsvTable();
	private mainRun tableKml= op.getKmlTable();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteFiles frame = new deleteFiles();
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
	public deleteFiles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCsv = new JButton("Yes");
		btnCsv.setForeground(Color.RED);
		btnCsv.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					File fr = new File("C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\gmon\\gmon.csv");
					fr.delete();
					//tableCsv= new mainRun();
					//tableKml= new mainRun();
					backToStart back= new backToStart();
					contentPane.hide();
					back.setVisible(true);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"error");
				}
			}
		});
		btnCsv.setBounds(152, 214, 188, 56);
		contentPane.add(btnCsv);

		JButton btnNewButton = new JButton("No");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextFrame next =new nextFrame();
				contentPane.hide();
				next.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(399, 214, 188, 56);
		contentPane.add(btnNewButton);

		JLabel lblIfYouChoose = new JLabel("Are you sure you want to delete this files?");
		lblIfYouChoose.setForeground(Color.RED);
		lblIfYouChoose.setHorizontalAlignment(SwingConstants.CENTER);
		lblIfYouChoose.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblIfYouChoose.setBounds(100, 116, 541, 56);
		contentPane.add(lblIfYouChoose);
	}

}

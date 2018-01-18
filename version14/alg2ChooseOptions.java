package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class alg2ChooseOptions extends JFrame {

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
					alg2ChooseOptions frame = new alg2ChooseOptions();
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
	public alg2ChooseOptions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnA = new JButton("A");
		btnA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alg2OptionA a =new alg2OptionA();
				a.setCsvPath(csvPath);
				a.setWigPath(wigglePath);

				contentPane.hide();
				a.setVisible(true);
			}
		});
		btnA.setBounds(357, 232, 87, 54);
		contentPane.add(btnA);
		
		JButton btnB = new JButton("B");
		btnB.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alg2OptionB b =new alg2OptionB();
				b.setCsvPath(csvPath);
				b.setWigPath(wigglePath);

				contentPane.hide();
				b.setVisible(true);
			}
		});
		btnB.setBounds(564, 232, 87, 54);
		contentPane.add(btnB);
		
		JLabel lblChooseWhichWay = new JLabel("choose which way you want to apply this algorithm:");
		lblChooseWhichWay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChooseWhichWay.setBounds(46, 32, 585, 43);
		contentPane.add(lblChooseWhichWay);
		
		JLabel lblChooseWhichWay_1 = new JLabel("(press A)- enter file name .csv and it will show you the accurate location by the whole row.");
		lblChooseWhichWay_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChooseWhichWay_1.setBounds(46, 77, 918, 43);
		contentPane.add(lblChooseWhichWay_1);
		
		JLabel lblpressBEnter = new JLabel("(press B)- enter 3 pairs of mac and signal and it will show you the accurate location by these pairs.");
		lblpressBEnter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblpressBEnter.setBounds(46, 136, 1055, 43);
		contentPane.add(lblpressBEnter);
	}

}

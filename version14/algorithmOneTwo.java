package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class algorithmOneTwo extends JFrame {

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
					algorithmOneTwo frame = new algorithmOneTwo();
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
	public algorithmOneTwo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPleaseChooseWhich = new JLabel("please choose which algorithm you want to use: one or two");
		lblPleaseChooseWhich.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseChooseWhich.setBounds(76, 68, 597, 20);
		contentPane.add(lblPleaseChooseWhich);

		JButton algorithm1 = new JButton("Algorithm1");
		algorithm1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		algorithm1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

					main alg1= new main();
					alg1.algorithm1(csvPath);
					
					contentPane.hide();
					JOptionPane.showMessageDialog(null, "go to your folder to see the changes after this algorithm");
					 
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in algorithm1 button");

				//	JOptionPane.showMessageDialog(null, "error in algorithm1 button");
				}

			}
		});
		algorithm1.setBounds(99, 227, 182, 57);
		contentPane.add(algorithm1);

		JButton algorithm2 = new JButton("Algorithm2");
		algorithm2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

					alg2ChooseOptions choose =new alg2ChooseOptions();
					choose.setCsvPath(csvPath);
					choose.setWigPath(wigglePath);

					contentPane.hide();
					choose.setVisible(true);
				 
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in algorithm1 button");

				//	JOptionPane.showMessageDialog(null, "error in algorithm1 button");
				}
			
			}
		});
		algorithm2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		algorithm2.setBounds(341, 227, 182, 57);
		contentPane.add(algorithm2);

		JLabel lblAlgoOnlyCreates = new JLabel("algo1 only creates csv file, but in algo 2 you may choose");
		lblAlgoOnlyCreates.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAlgoOnlyCreates.setBounds(76, 104, 533, 29);
		contentPane.add(lblAlgoOnlyCreates);

		JLabel lblInAlgoYou = new JLabel("the way you want to use this algorithm");
		lblInAlgoYou.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInAlgoYou.setBounds(76, 149, 526, 20);
		contentPane.add(lblInAlgoYou);
	}
}

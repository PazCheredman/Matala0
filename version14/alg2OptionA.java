package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class alg2OptionA extends JFrame {

	private JPanel contentPane;
	private JTextField textComb;
	private JTextField NoGps;
	private boolean ok1=false,ok2=false;
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
					alg2OptionA frame = new alg2OptionA();
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
	public alg2OptionA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textComb = new JTextField();
		textComb.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textComb.setBounds(25, 62, 779, 59);
		contentPane.add(textComb);
		textComb.setColumns(10);
		
		JLabel lblEnter = new JLabel("enter _comb_all_BM2_ file");
		lblEnter.setBounds(25, 26, 315, 20);
		contentPane.add(lblEnter);
		
		JButton okComb = new JButton("OK");
		okComb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path;
				try{
					if(!textComb.getText().isEmpty()){
						path=textComb.getText();
						ok1=true;
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of textComb null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of textComb button");
				}
			}
		});
		okComb.setBounds(819, 62, 115, 29);
		contentPane.add(okComb);
		
		JLabel lblEntercombnogpstsFile = new JLabel("enter _comb_no_gps_ts1 file");
		lblEntercombnogpstsFile.setBounds(25, 126, 315, 20);
		contentPane.add(lblEntercombnogpstsFile);
		
		NoGps = new JTextField();
		NoGps.setFont(new Font("Tahoma", Font.PLAIN, 24));
		NoGps.setColumns(10);
		NoGps.setBounds(25, 162, 779, 59);
		contentPane.add(NoGps);
		
		JButton okNoGps = new JButton("OK");
		okNoGps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path;
				try{
					if(!okNoGps.getText().isEmpty()){
						path=okNoGps.getText();
						ok2=true;
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of noGps null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of noGps button");
				}
			}
		});
		okNoGps.setBounds(819, 169, 115, 29);
		contentPane.add(okNoGps);
		
		JButton btnNext = new JButton("next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(ok1 && ok2){
						main m= new main();
						m.algorithm2OptionA(csvPath,textComb.getText(),NoGps.getText());
					}
					else{
						JOptionPane.showMessageDialog(null, "please enter paths to text boxes above");
					}
					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input ok1,ok2 buttons");
				}
				
			}
		});
		btnNext.setBounds(321, 250, 115, 29);
		contentPane.add(btnNext);
	}
}

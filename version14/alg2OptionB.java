package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class alg2OptionB extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblEnterSignal;
	private JLabel lblEnterSignal_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblEnterSignal_2;
	private JButton next;
	private JButton ok1;
	private JButton ok2;
	private JButton ok3;
	private JButton ok4;
	private JButton ok5;
	private JButton ok6;
	private boolean ok_1 =false, ok_2 =false, ok_3 =false, ok_4 =false, ok_5 =false, ok_6 =false;
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
					alg2OptionB frame = new alg2OptionB();
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
	public alg2OptionB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterMac = new JLabel("enter mac 1:");
		lblEnterMac.setBounds(49, 36, 90, 20);
		contentPane.add(lblEnterMac);

		JLabel lblEnterMac_1 = new JLabel("enter mac 2:");
		lblEnterMac_1.setBounds(49, 129, 90, 20);
		contentPane.add(lblEnterMac_1);

		JLabel lblEnterMac_2 = new JLabel("enter mac 3:");
		lblEnterMac_2.setBounds(49, 216, 90, 20);
		contentPane.add(lblEnterMac_2);

		textField = new JTextField();
		textField.setBounds(160, 36, 184, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(160, 75, 184, 26);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 126, 184, 26);
		contentPane.add(textField_2);

		lblEnterSignal = new JLabel("enter signal 1:");
		lblEnterSignal.setBounds(49, 78, 110, 20);
		contentPane.add(lblEnterSignal);

		lblEnterSignal_1 = new JLabel("enter signal 2:");
		lblEnterSignal_1.setBounds(49, 165, 110, 20);
		contentPane.add(lblEnterSignal_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(160, 171, 184, 26);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(160, 213, 184, 26);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(160, 257, 184, 26);
		contentPane.add(textField_5);

		lblEnterSignal_2 = new JLabel("enter signal 3:");
		lblEnterSignal_2.setBounds(49, 260, 110, 20);
		contentPane.add(lblEnterSignal_2);

		next = new JButton("next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(ok_1 && ok_2 && ok_3 && ok_4 && ok_5 && ok_6){
						main m= new main();
						m.algorithm2OptionB(csvPath, textField.getText(), textField_1.getText(), 
								textField_2.getText(), textField_3.getText(),
								textField_4.getText(), textField_5.getText());
					}
					else{
						JOptionPane.showMessageDialog(null, "please enter paths to text boxes above");
					}

				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input ok1,ok2 buttons");
				}
			}
		});
		next.setBounds(133, 299, 115, 29);
		contentPane.add(next);

		ok1 = new JButton("ok");
		ok1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path;
				try{
					if(!textField.getText().isEmpty()){
						path=textField.getText();
						ok_1=true;
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of textField button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of textField button");
				}
			}
		});
		ok1.setBounds(359, 31, 49, 30);
		contentPane.add(ok1);

		ok2 = new JButton("ok");
		ok2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path;
				try{
					if(!textField_1.getText().isEmpty()){
						path=textField_1.getText();
						ok_2=true;
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of textField_1 button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of textField_1 button");
				}
			}
		});
		ok2.setBounds(359, 74, 49, 30);
		contentPane.add(ok2);

		ok3 = new JButton("ok");
		ok3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path;
				try{
					if(!textField_2.getText().isEmpty()){
						path=textField_2.getText();
						ok_3=true;
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of textField_2 button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of textField_2 button");
				}
			}
		});
		ok3.setBounds(359, 120, 49, 30);
		contentPane.add(ok3);

		ok4 = new JButton("ok");
		ok4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path;
				try{
					if(!textField_3.getText().isEmpty()){
						path=textField_3.getText();
						ok_4=true;
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of textField_3 button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of textField_3 button");
				}
			}
		});
		ok4.setBounds(359, 169, 49, 30);
		contentPane.add(ok4);

		ok5 = new JButton("ok");
		ok5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path;
				try{
					if(!textField_4.getText().isEmpty()){
						path=textField_4.getText();
						ok_5=true;
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of textField_4 button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of textField_4 button");
				}
			}
		});
		ok5.setBounds(359, 212, 49, 30);
		contentPane.add(ok5);

		ok6 = new JButton("ok");
		ok6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path;
				try{
					if(!textField_5.getText().isEmpty()){
						path=textField_5.getText();
						ok_6=true;
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of textField_5 button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of textField_5 button");
				}
			}
		});
		ok6.setBounds(359, 256, 49, 30);
		contentPane.add(ok6);
	}

}

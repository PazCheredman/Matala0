package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class timeFil extends JFrame {

	private JPanel contentPane;
	private String csvPath;
	private String wigglePath;
	private JTextField textTimeMax;
	private JTextField textTimeMin;
	private boolean ok_1=false, ok_2=false;
	
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
					timeFil frame = new timeFil();
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
	public timeFil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterTimeMax = new JLabel("enter time max:");
		lblEnterTimeMax.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEnterTimeMax.setBounds(31, 172, 161, 20);
		contentPane.add(lblEnterTimeMax);
		
		JLabel lblEnterTimeMin = new JLabel("enter time min:");
		lblEnterTimeMin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEnterTimeMin.setBounds(31, 110, 161, 47);
		contentPane.add(lblEnterTimeMin);
		
		textTimeMax = new JTextField();
		textTimeMax.setBounds(207, 172, 146, 26);
		contentPane.add(textTimeMax);
		textTimeMax.setColumns(10);
		
		textTimeMin = new JTextField();
		textTimeMin.setBounds(207, 123, 146, 26);
		contentPane.add(textTimeMin);
		textTimeMin.setColumns(10);
		
		JButton ok1 = new JButton("ok");
		ok1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textTimeMin.getText().isEmpty()){
					ok_1=true;
				}
			}
		});
		ok1.setBounds(368, 122, 59, 29);
		contentPane.add(ok1);
		
		JButton ok2 = new JButton("ok");
		ok2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textTimeMax.getText().isEmpty()){
					ok_2=true;
				}
			}
		});
		ok2.setBounds(368, 171, 59, 29);
		contentPane.add(ok2);
		
		JLabel lblEnterYearmonthday = new JLabel("enter: year-month-day |& time by 24 format (not 12 format am.pm)");
		lblEnterYearmonthday.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEnterYearmonthday.setBounds(31, 37, 776, 70);
		contentPane.add(lblEnterYearmonthday);
		
		JButton btnNext = new JButton("next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				if(ok_1 && ok_2){
					String timeMin= textTimeMin.getText();
					String timeMax= textTimeMax.getText();
					main m= new main();
					m.time(csvPath, timeMin, timeMax);
					String sub =csvPath.substring(0, csvPath.length()-9);
					testKml kmlId= new testKml();	
					kmlId.readCsvFile(sub, "time.csv");
				}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of textFields button");				
				}
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNext.setBounds(207, 214, 127, 35);
		contentPane.add(btnNext);
	}

}

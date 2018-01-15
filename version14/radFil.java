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

public class radFil extends JFrame {

	private JPanel contentPane;
	private JTextField latText;
	private JTextField lonText;
	private JTextField altText;
	private JTextField radText;
	private boolean ok_1=false, ok_2=false, ok_3=false, ok_4=false;
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
					radFil frame = new radFil();
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
	public radFil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		latText = new JTextField();
		latText.setBounds(160, 129, 146, 26);
		contentPane.add(latText);
		latText.setColumns(10);
		
		JLabel lblEnterLat = new JLabel("enter lat");
		lblEnterLat.setBounds(49, 132, 69, 20);
		contentPane.add(lblEnterLat);
		
		JLabel lblEnterLon = new JLabel("enter lon");
		lblEnterLon.setBounds(49, 168, 69, 20);
		contentPane.add(lblEnterLon);
		
		JLabel lblEnterAlt = new JLabel("enter alt");
		lblEnterAlt.setBounds(49, 204, 69, 20);
		contentPane.add(lblEnterAlt);
		
		lonText = new JTextField();
		lonText.setBounds(160, 165, 146, 26);
		contentPane.add(lonText);
		lonText.setColumns(10);
		
		altText = new JTextField();
		altText.setBounds(160, 201, 146, 26);
		contentPane.add(altText);
		altText.setColumns(10);
		
		JLabel lblEnterRadious = new JLabel("enter radious");
		lblEnterRadious.setBounds(49, 240, 122, 20);
		contentPane.add(lblEnterRadious);
		
		radText = new JTextField();
		radText.setBounds(160, 237, 146, 26);
		contentPane.add(radText);
		radText.setColumns(10);
		
		JButton ok1 = new JButton("ok");
		ok1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!latText.getText().isEmpty()){
					ok_1=true;
				}
			}
		});
		ok1.setBounds(315, 128, 49, 29);
		contentPane.add(ok1);
		
		JButton ok2 = new JButton("ok");
		ok2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!lonText.getText().isEmpty()){
					ok_2=true;
				}
			}
		});
		ok2.setBounds(315, 164, 49, 29);
		contentPane.add(ok2);
		
		JButton ok3 = new JButton("ok");
		ok3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!altText.getText().isEmpty()){
					ok_3=true;
				}
			}
		});
		ok3.setBounds(315, 200, 49, 29);
		contentPane.add(ok3);
		
		JButton ok4 = new JButton("ok");
		ok4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!radText.getText().isEmpty()){
					ok_4=true;
				}
			}
		});
		ok4.setBounds(315, 236, 49, 29);
		contentPane.add(ok4);
		
		JLabel lblPleaseEntetLatlonalt = new JLabel("please entet lat,lon,alt and the radious that you want to do");
		lblPleaseEntetLatlonalt.setBounds(15, 31, 435, 49);
		contentPane.add(lblPleaseEntetLatlonalt);
		
		JLabel lblSearchAccortingTo = new JLabel(" the search according to:");
		lblSearchAccortingTo.setBounds(15, 62, 435, 49);
		contentPane.add(lblSearchAccortingTo);
		
		JButton next = new JButton("next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(ok_1 && ok_2 && ok_3 && ok_4){
						main m= new main();
						m.radius(csvPath,latText.getText(),lonText.getText(),altText.getText(),radText.getText());
						JOptionPane.showMessageDialog(null, "go to the folder to see output");
						contentPane.hide();
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of textField button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of textField button");				}
			}
	//		}
		});
		next.setBounds(174, 295, 81, 29);
		contentPane.add(next);
	}
}

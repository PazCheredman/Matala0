package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;

public class moreFil extends JFrame {

	private JPanel contentPane;
	private String csvPath;
	private String wigglePath;
	private boolean ok1 = false, ok2 = false, ok3 = false, ok4 = false;


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
					moreFil frame = new moreFil();
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
	public moreFil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAnd = new JButton("and");
		btnAnd.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if the time filter is chosen
				if(ok1){
					timeFil tim= new timeFil();
					tim.setCsvPath(csvPath);
					contentPane.hide();
					tim.setVisible(true);

					if(ok2 && ok3 && ok4){
						idFil id= new idFil();
						id.setCsvPath(timePath); //should get the path of the time csv after the time filter
						contentPane.hide();
						id.setVisible(true);

						locFil loc= new locFil();
						loc.setCsvPath(idPath); //should get the path of the id csv after the time,id filter
						contentPane.hide();
						loc.setVisible(true);

						radFil rad= new radFil();
						rad.setCsvPath(locPath); //should get the path of the loc csv after the time,id,loc filter
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(ok2 && ok3 && !ok4){
						idFil id= new idFil();
						id.setCsvPath(timePath); //should get the path of the time csv after the time filter
						contentPane.hide();
						id.setVisible(true);

						locFil loc= new locFil();
						loc.setCsvPath(idPath); //should get the path of the id csv after the time,id filter
						contentPane.hide();
						loc.setVisible(true);
					}
					else if(ok2 && !ok3 && ok4){
						idFil id= new idFil();
						id.setCsvPath(timePath); //should get the path of the time csv after the time filter
						contentPane.hide();
						id.setVisible(true);

						radFil rad= new radFil();
						rad.setCsvPath(idPath); //should get the path of the id csv after the time,id filter
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(!ok2 && ok3 && ok4){
						locFil loc= new locFil();
						loc.setCsvPath(timePath); //should get the path of the time csv after the time filter
						contentPane.hide();
						loc.setVisible(true);

						radFil rad= new radFil();
						rad.setCsvPath(locPath); //should get the path of the loc csv after the time,loc filter
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(ok2 && !ok3 && !ok4){
						idFil id= new idFil();
						id.setCsvPath(timePath); //should get the path of the time csv after the time filter
						contentPane.hide();
						id.setVisible(true);
					}
					else if(!ok2 && ok3 && !ok4){
						locFil loc= new locFil();
						loc.setCsvPath(timePath); //should get the path of the time csv after the time filter
						contentPane.hide();
						loc.setVisible(true);
					}
					else if(!ok2 && !ok3 && ok4){
						radFil rad= new radFil();
						rad.setCsvPath(timePath); //should get the path of the time csv after the time filter
						contentPane.hide();
						rad.setVisible(true);
					}
				}
				//if the id filter is chosen (and the time is'nt)
				else if(ok2){
					idFil id= new idFil();
					id.setCsvPath(csvPath);
					contentPane.hide();
					id.setVisible(true);

					if(ok3 && ok4){
						locFil loc= new locFil();
						loc.setCsvPath(idPath); //should get the path of the id csv after the id filter
						contentPane.hide();
						loc.setVisible(true);

						radFil rad= new radFil();
						rad.setCsvPath(locPath); //should get the path of the loc csv after the id,loc filter
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(ok3 && !ok4){
						locFil loc= new locFil();
						loc.setCsvPath(idPath); //should get the path of the id csv after the id filter
						contentPane.hide();
						loc.setVisible(true);
					}
					else if(!ok3 && ok4){
						radFil rad= new radFil();
						rad.setCsvPath(idPath); //should get the path of the id csv after the id filter
						contentPane.hide();
						rad.setVisible(true);
					}
				}
				//if the loc filter is chosen(and the time+id are'nt)
				else if(ok3){
					locFil loc= new locFil();
					loc.setCsvPath(csvPath); 
					contentPane.hide();
					loc.setVisible(true);

					if(ok4){
						radFil rad= new radFil();
						rad.setCsvPath(locPath); //should get the path of the loc csv after the loc filter
						contentPane.hide();
						rad.setVisible(true);
					}
				}
				//if the rad filter is chosen(and the time+id+loc are'nt)
				else if(ok3){
					radFil rad= new radFil();
					rad.setCsvPath(csvPath); 
					contentPane.hide();
					rad.setVisible(true);
				}
			}
		});
		btnAnd.setBounds(54, 247, 97, 29);
		contentPane.add(btnAnd);

		JCheckBox chckbxTimeFilter = new JCheckBox("time filter");
		chckbxTimeFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxTimeFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok1 = true;
			}
		});
		chckbxTimeFilter.setBounds(12, 134, 139, 29);
		contentPane.add(chckbxTimeFilter);

		JCheckBox chckbxIdFilter = new JCheckBox("ID filter");
		chckbxIdFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxIdFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok2 = true;
			}
		});
		chckbxIdFilter.setBounds(188, 136, 113, 25);
		contentPane.add(chckbxIdFilter);

		JCheckBox chckbxRadiusFilter = new JCheckBox("radius filter");
		chckbxRadiusFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxRadiusFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok3 = true;
			}
		});
		chckbxRadiusFilter.setBounds(348, 136, 149, 25);
		contentPane.add(chckbxRadiusFilter);

		JCheckBox chckbxLocationFilter = new JCheckBox("location filter");
		chckbxLocationFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxLocationFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok4 = true;
			}
		});
		chckbxLocationFilter.setBounds(538, 136, 166, 25);
		contentPane.add(chckbxLocationFilter);

		JButton btnOr = new JButton("or");
		btnOr.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnOr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnOr.setBounds(318, 247, 97, 29);
		contentPane.add(btnOr);

		JButton btnNot = new JButton("not");
		btnNot.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNot.setBounds(544, 247, 97, 29);
		contentPane.add(btnNot);
		
		JLabel lblPleaseChooseWhich = new JLabel("please choose which filters would you like to use and how:");
		lblPleaseChooseWhich.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPleaseChooseWhich.setBounds(12, 61, 692, 37);
		contentPane.add(lblPleaseChooseWhich);
	}
}

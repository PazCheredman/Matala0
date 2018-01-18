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

public class morreFil extends JFrame {

	private JPanel contentPane;
	private String csvPath;
	private String wigglePath;
	private boolean ok1 = false, ok2 = false, ok3 = false, ok4 = false,
			okNot1 = false, okNot2 = false, okNot3 = false, okNot4 = false;


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
					morreFil frame = new morreFil();
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
	public morreFil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 411);
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
					
					//id or idNot
					if(ok2){
						idFil id= new idFil();
						id.setCsvPath(tim.getTimeCsv()); 
						contentPane.hide();
						id.setVisible(true);
					}
					else if(okNot2){
						idFil idNot= new idFil();
						idNot.setnotFilter(true);
						idNot.setCsvPath(tim.getTimeCsv()); 
						contentPane.hide();
						idNot.setVisible(true);
					}

					//loc or locNot
					else if(ok3){
						locFil loc= new locFil();
						loc.setCsvPath(tim.getTimeCsv()); 
						contentPane.hide();
						loc.setVisible(true);
					}
					else if(okNot3){
						locFil locNot= new locFil();
						locNot.setnotFilter(true);
						locNot.setCsvPath(tim.getTimeCsv()); 
						contentPane.hide();
						locNot.setVisible(true);
					}

					//rad or radNot
					else if(ok4){
						radFil rad= new radFil();
						rad.setCsvPath(tim.getTimeCsv());
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(okNot4){
						radFil radNot= new radFil();
						radNot.setnotFilter(true);
						radNot.setCsvPath(tim.getTimeCsv()); 
						contentPane.hide();
						radNot.setVisible(true);
					}
				}

				//if timeNot is chosen
				else if(okNot1){
					timeFil timNot= new timeFil();
					timNot.setnotFilter(true);
					timNot.setCsvPath(csvPath);
					contentPane.hide();
					timNot.setVisible(true);

					//id or idNot
					if(ok2){
						idFil id= new idFil();
						id.setCsvPath(timNot.getTimeNotCsv());
						contentPane.hide();
						id.setVisible(true);
					}
					else if(okNot2){
						idFil idNot= new idFil();
						idNot.setnotFilter(true);
						idNot.setCsvPath(timNot.getTimeNotCsv()); 
						contentPane.hide();
						idNot.setVisible(true);
					}

					//loc or locNot
					else if(ok3){
						locFil loc= new locFil();
						loc.setCsvPath(timNot.getTimeNotCsv());
						contentPane.hide();
						loc.setVisible(true);
					}
					else if(okNot3){
						locFil locNot= new locFil();
						locNot.setnotFilter(true);
						locNot.setCsvPath(timNot.getTimeNotCsv()); 
						contentPane.hide();
						locNot.setVisible(true);
					}

					//rad or radNot
					else if(ok4){
						radFil rad= new radFil();
						rad.setCsvPath(timNot.getTimeNotCsv()); 
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(okNot4){
						radFil radNot= new radFil();
						radNot.setnotFilter(true);
						radNot.setCsvPath(timNot.getTimeNotCsv());
						contentPane.hide();
						radNot.setVisible(true);
					}

				}

				//if the id filter is chosen (and the time is'nt)
				else if(ok2){
					idFil id= new idFil();
					id.setCsvPath(csvPath);
					contentPane.hide();
					id.setVisible(true);

					//loc or locNot
					if(ok3){
						locFil loc= new locFil();
						loc.setCsvPath(id.getIdCsv()); 
						contentPane.hide();
						loc.setVisible(true);
					}
					else if(okNot3){
						locFil locNot= new locFil();
						locNot.setnotFilter(true);
						locNot.setCsvPath(id.getIdCsv());
						contentPane.hide();
						locNot.setVisible(true);
					}

					//rad or radNot
					else if(ok4){
						radFil rad= new radFil();
						rad.setCsvPath(id.getIdCsv()); 
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(okNot4){
						radFil radNot= new radFil();
						radNot.setnotFilter(true);
						radNot.setCsvPath(id.getIdCsv()); 
						contentPane.hide();
						radNot.setVisible(true);
					}
				}

				//if idNot is chosen
				else if(okNot2){
					idFil idNot= new idFil();
					idNot.setCsvPath(csvPath);
					contentPane.hide();
					idNot.setVisible(true);

					//loc or locNot
					if(ok3){
						locFil loc= new locFil();
						loc.setCsvPath(idNot.getIdNotCsv());
						contentPane.hide();
						loc.setVisible(true);
					}
					else if(okNot3){
						locFil locNot= new locFil();
						locNot.setnotFilter(true);
						locNot.setCsvPath(idNot.getIdNotCsv()); 
						contentPane.hide();
						locNot.setVisible(true);
					}

					//rad or radNot
					else if(ok4){
						radFil rad= new radFil();
						rad.setCsvPath(idNot.getIdNotCsv()); 
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(okNot4){
						radFil radNot= new radFil();
						radNot.setnotFilter(true);
						radNot.setCsvPath(idNot.getIdNotCsv());
						contentPane.hide();
						radNot.setVisible(true);
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
						rad.setCsvPath(loc.getLocCsv()); 
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(okNot4){
						radFil radNot= new radFil();
						radNot.setnotFilter(true);
						radNot.setCsvPath(loc.getLocCsv());
						contentPane.hide();
						radNot.setVisible(true);
					}
				}

				//if locNot is chosen
				else if(okNot3){
					locFil locNot= new locFil();
					locNot.setCsvPath(csvPath); 
					contentPane.hide();
					locNot.setVisible(true);

					if(ok4){
						radFil rad= new radFil();
						rad.setCsvPath(locNot.getLocNotCsv());
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(okNot4){
						radFil radNot= new radFil();
						radNot.setnotFilter(true);
						radNot.setCsvPath(locNot.getLocNotCsv());
						contentPane.hide();
						radNot.setVisible(true);
					}
				}

				//if the rad filter is chosen(and the time+id+loc are'nt)
				else if(ok4){
					radFil rad= new radFil();
					rad.setCsvPath(csvPath); 
					contentPane.hide();
					rad.setVisible(true);
				}

				// if the radNot is chosen
				else if(okNot4){
					radFil radNot= new radFil();
					radNot.setnotFilter(true);
					radNot.setCsvPath(csvPath);
					contentPane.hide();
					radNot.setVisible(true);
				}
			}
		});
		btnAnd.setBounds(204, 247, 97, 29);
		contentPane.add(btnAnd);

		JCheckBox chckbxTimeFilter = new JCheckBox("time filter");
		chckbxTimeFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxTimeFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok1 = true;
				okNot1 = false;
			}
		});
		chckbxTimeFilter.setBounds(12, 146, 139, 29);
		contentPane.add(chckbxTimeFilter);

		JCheckBox chckbxIdFilter = new JCheckBox("ID filter");
		chckbxIdFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxIdFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok2 = true;
				okNot2 = false;
			}
		});
		chckbxIdFilter.setBounds(188, 148, 113, 25);
		contentPane.add(chckbxIdFilter);

		JCheckBox chckbxRadiusFilter = new JCheckBox("radius filter");
		chckbxRadiusFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxRadiusFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok3 = true;
				okNot3 = false;
			}
		});
		chckbxRadiusFilter.setBounds(348, 148, 149, 25);
		contentPane.add(chckbxRadiusFilter);

		JCheckBox chckbxLocationFilter = new JCheckBox("location filter");
		chckbxLocationFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxLocationFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok4 = true;
				okNot4 = false;
			}
		});
		chckbxLocationFilter.setBounds(538, 148, 166, 25);
		contentPane.add(chckbxLocationFilter);

		JButton btnOr = new JButton("or");
		btnOr.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnOr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if the time filter is chosen
				if(ok1){
					timeFil tim= new timeFil();
					tim.setCsvPath(csvPath);
					contentPane.hide();
					tim.setVisible(true);

					//id or idNot
					if(ok2){
						idFil id= new idFil();
						id.setCsvPath(csvPath); 
						contentPane.hide();
						id.setVisible(true);
					}
					else if(okNot2){
						idFil idNot= new idFil();
						idNot.setnotFilter(true);
						idNot.setCsvPath(csvPath); 
						contentPane.hide();
						idNot.setVisible(true);
					}

					//loc or locNot
					else if(ok3){
						locFil loc= new locFil();
						loc.setCsvPath(csvPath);
						contentPane.hide();
						loc.setVisible(true);
					}
					else if(okNot3){
						locFil locNot= new locFil();
						locNot.setnotFilter(true);
						locNot.setCsvPath(csvPath);
						contentPane.hide();
						locNot.setVisible(true);
					}

					//rad or radNot
					else if(ok4){
						radFil rad= new radFil();
						rad.setCsvPath(csvPath); 
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(okNot4){
						radFil radNot= new radFil();
						radNot.setnotFilter(true);
						radNot.setCsvPath(csvPath);
						contentPane.hide();
						radNot.setVisible(true);
					}

				}

				//if timeNot is chosen
				else if(okNot1){
					timeFil timNot= new timeFil();
					timNot.setnotFilter(true);
					timNot.setCsvPath(csvPath);
					contentPane.hide();
					timNot.setVisible(true);

					//id or idNot
					if(ok2){
						idFil id= new idFil();
						id.setCsvPath(csvPath);
						contentPane.hide();
						id.setVisible(true);
					}
					else if(okNot2){
						idFil idNot= new idFil();
						idNot.setnotFilter(true);
						idNot.setCsvPath(csvPath);
						contentPane.hide();
						idNot.setVisible(true);
					}

					//loc or locNot
					else if(ok3){
						locFil loc= new locFil();
						loc.setCsvPath(csvPath); 
						contentPane.hide();
						loc.setVisible(true);
					}
					else if(okNot3){
						locFil locNot= new locFil();
						locNot.setnotFilter(true);
						locNot.setCsvPath(csvPath); 
						contentPane.hide();
						locNot.setVisible(true);
					}

					//rad or radNot
					else if(ok4){
						radFil rad= new radFil();
						rad.setCsvPath(csvPath); 
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(okNot4){
						radFil radNot= new radFil();
						radNot.setnotFilter(true);
						radNot.setCsvPath(csvPath);
						contentPane.hide();
						radNot.setVisible(true);
					}

				}

				//if the id filter is chosen (and the time is'nt)
				else if(ok2){
					idFil id= new idFil();
					id.setCsvPath(csvPath);
					contentPane.hide();
					id.setVisible(true);

					//loc or locNot
					if(ok3){
						locFil loc= new locFil();
						loc.setCsvPath(csvPath);
						contentPane.hide();
						loc.setVisible(true);
					}
					else if(okNot3){
						locFil locNot= new locFil();
						locNot.setnotFilter(true);
						locNot.setCsvPath(csvPath);
						contentPane.hide();
						locNot.setVisible(true);
					}

					//rad or radNot
					else if(ok4){
						radFil rad= new radFil();
						rad.setCsvPath(csvPath); 
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(okNot4){
						radFil radNot= new radFil();
						radNot.setnotFilter(true);
						radNot.setCsvPath(csvPath);
						contentPane.hide();
						radNot.setVisible(true);
					}
				}

				//if idNot is chosen
				else if(okNot2){
					idFil idNot= new idFil();
					idNot.setCsvPath(csvPath);
					contentPane.hide();
					idNot.setVisible(true);

					//loc or locNot
					if(ok3){
						locFil loc= new locFil();
						loc.setCsvPath(csvPath); 
						contentPane.hide();
						loc.setVisible(true);
					}
					else if(okNot3){
						locFil locNot= new locFil();
						locNot.setnotFilter(true);
						locNot.setCsvPath(csvPath);
						contentPane.hide();
						locNot.setVisible(true);
					}

					//rad or radNot
					else if(ok4){
						radFil rad= new radFil();
						rad.setCsvPath(csvPath); 
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(okNot4){
						radFil radNot= new radFil();
						radNot.setnotFilter(true);
						radNot.setCsvPath(csvPath); 
						contentPane.hide();
						radNot.setVisible(true);
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
						rad.setCsvPath(csvPath); 
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(okNot4){
						radFil radNot= new radFil();
						radNot.setnotFilter(true);
						radNot.setCsvPath(csvPath);
						contentPane.hide();
						radNot.setVisible(true);
					}
				}

				//if locNot is chosen
				else if(okNot3){
					locFil locNot= new locFil();
					locNot.setCsvPath(csvPath); 
					contentPane.hide();
					locNot.setVisible(true);

					if(ok4){
						radFil rad= new radFil();
						rad.setCsvPath(csvPath); 
						contentPane.hide();
						rad.setVisible(true);
					}
					else if(okNot4){
						radFil radNot= new radFil();
						radNot.setnotFilter(true);
						radNot.setCsvPath(csvPath);
						contentPane.hide();
						radNot.setVisible(true);
					}
				}

				//if the rad filter is chosen(and the time+id+loc are'nt)
				else if(ok4){
					radFil rad= new radFil();
					rad.setCsvPath(csvPath); 
					contentPane.hide();
					rad.setVisible(true);
				}

				// if the radNot is chosen
				else if(okNot4){
					radFil radNot= new radFil();
					radNot.setnotFilter(true);
					radNot.setCsvPath(csvPath);
					contentPane.hide();
					radNot.setVisible(true);
				}
			}
		});
		btnOr.setBounds(437, 247, 97, 29);
		contentPane.add(btnOr);

		JLabel lblPleaseChooseWhich = new JLabel("please choose which filters would you like to use and how:");
		lblPleaseChooseWhich.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPleaseChooseWhich.setBounds(12, 28, 692, 37);
		contentPane.add(lblPleaseChooseWhich);

		JCheckBox chckbxTimenotFilter = new JCheckBox("timeNot filter");
		chckbxTimenotFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				okNot1 = true;
				ok1 = false;
			}
		});
		chckbxTimenotFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxTimenotFilter.setBounds(12, 184, 166, 29);
		contentPane.add(chckbxTimenotFilter);

		JCheckBox chckbxIdnotFilter = new JCheckBox("IDNot filter");
		chckbxIdnotFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okNot2 = true;
				ok2 = false;
			}
		});
		chckbxIdnotFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxIdnotFilter.setBounds(188, 190, 149, 25);
		contentPane.add(chckbxIdnotFilter);

		JCheckBox chckbxRadiusnotFilter = new JCheckBox("radiusNot filter");
		chckbxRadiusnotFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okNot3 = true;
				ok3 = false;
			}
		});
		chckbxRadiusnotFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxRadiusnotFilter.setBounds(348, 190, 186, 25);
		contentPane.add(chckbxRadiusnotFilter);

		JCheckBox chckbxLocationnotFilter = new JCheckBox("locationNot filter");
		chckbxLocationnotFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okNot4 = true;
				ok4 = false;
			}
		});
		chckbxLocationnotFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxLocationnotFilter.setBounds(538, 190, 198, 25);
		contentPane.add(chckbxLocationnotFilter);

		JLabel lblNoteYouCant = new JLabel("NOTE: you can't choose the same filter in two different ways, ");
		lblNoteYouCant.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNoteYouCant.setBounds(12, 66, 645, 29);
		contentPane.add(lblNoteYouCant);

		JLabel lblForExampleTime = new JLabel("for example- time + timeNot");
		lblForExampleTime.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblForExampleTime.setBounds(12, 96, 470, 29);
		contentPane.add(lblForExampleTime);
	}
}

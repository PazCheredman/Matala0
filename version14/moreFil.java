package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class moreFil extends JFrame {

	private table tables;
	private JPanel contentPane;
	private String csvPath,sub =csvPath.substring(0, csvPath.length()-9); ;
	private String wigglePath;
	private boolean ok1 = false, ok2 = false, ok3 = false, ok4 = false,
			okNot1 = false, okNot2 = false, okNot3 = false, okNot4 = false;
	private boolean andPressed=false,orPressed=false ;
	private int arr[];
	private orFil orfil=new orFil();
	
	
	public String getSub() {
		return sub;
	}

	public boolean isOrPressed() {
		return orPressed;
	}

	public void setOrPressed(boolean orPressed) {
		this.orPressed = orPressed;
	}

	public boolean isAndPressed() {
		return andPressed;
	}

	public void setAndPressed(boolean andPressed) {
		this.andPressed = andPressed;
	}

	public void nextWindowAnd(String path,String fileRecevied, int number){
		switch (number){
		case 1:
			if (isOk1() || isOkNot1()){
				chooseTime(path+"\\"+fileRecevied);
			}
		case 2:
			if (isOk2() || isOkNot2()){
				chooseId(path+"\\"+fileRecevied);
			}
		case 3:
			if (isOk3() || isOkNot3()){
				chooseLoc(path+"\\"+fileRecevied);
			}
		case 4:
			if (isOk4() || isOkNot4()){
				chooseRad(path+"\\"+fileRecevied);
			}
		}
	}

	public void nextWindowOr(int number){
		switch (number){
		case 1:
			if (isOk1() || isOkNot1()){
				chooseTime(csvPath);
			}
		case 2:
			if (isOk2() || isOkNot2()){
				chooseId(csvPath);
			}
		case 3:
			if (isOk3() || isOkNot3()){
				chooseLoc(csvPath);
			}
		case 4:
			if (isOk4() || isOkNot4()){
				chooseRad(csvPath);
			}
		}
	}

	public boolean isOk1() {
		return ok1;
	}

	public boolean isOk2() {
		return ok2;
	}

	public boolean isOk3() {
		return ok3;
	}

	public boolean isOk4() {
		return ok4;
	}

	public boolean isOkNot1() {
		return okNot1;
	}

	public boolean isOkNot2() {
		return okNot2;
	}

	public boolean isOkNot3() {
		return okNot3;
	}

	public boolean isOkNot4() {
		return okNot4;
	}

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


	/*public boolean readFolderTime(String directory){
		File folder=new File(directory);
		tables=new table();
		if(directory.contains("time.csv"))	{
			return true;
		}
		return false;
	}*/

	public void chooseTime(String path){
		timeFil tim= new timeFil();
		timeFil timNot= new timeFil();
		tim.setMore(this);
		timNot.setMore(this);
		if(ok1){
			tim.setCsvPath(path);
			tim.setVisible(true);
		}
		else{// if(okNot1){ 
			timNot.setnotFilter(true);
			timNot.setCsvPath(path);
			timNot.setVisible(true);
		}
	}

	public void chooseId(String path){
		idFil id= new idFil();
		idFil idNot= new idFil();
		id.setMore(this);
		idNot.setMore(this);
		if(ok2){
			id.setCsvPath(path); 
			id.setVisible(true);
		}
		else{// if(okNot2){ //idNot
			idNot.setnotFilter(true);
			idNot.setCsvPath(path); 
			idNot.setVisible(true);
		}
	}

	public void chooseLoc(String path){
		locFil loc= new locFil();
		locFil locNot= new locFil();
		loc.setMore(this);
		locNot.setMore(this);
		if(ok3){
			loc.setCsvPath(path); 
			loc.setVisible(true);
		}
		else{// if(okNot3){//locNot
			locNot.setnotFilter(true);
			locNot.setCsvPath(path); 
			locNot.setVisible(true);
		}
	}

	public void chooseRad(String path){
		radFil rad= new radFil();
		radFil radNot= new radFil();
		rad.setMore(this);
		radNot.setMore(this);
		if(ok4){
			rad.setCsvPath(path);
			rad.setVisible(true);
		}
		else{// if(okNot4){ //radNot
			radNot.setnotFilter(true);
			radNot.setCsvPath(path); 
			radNot.setVisible(true);
		}
	}

	public int whoPressed(){
		if(ok1) return 1;
		else if(ok2) return 2;
		else if(ok3) return 3;
		else if(ok4) return 4;
		else if(okNot1) return 5;
		else if(okNot2) return 6;
		else if(okNot3) return 7;
		else if(okNot4) return 8;
		return -1;
	}

	public void press(String path, int number){
		switch (number){
		case 1:
			orfil.setFilename1("time.csv");

		case 2:
			orfil.setFilename1("id.csv");

		case 3:
			orfil.setFilename1("time.csv");

		case 4:
			orfil.setFilename1("time.csv");
		}
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
		setBounds(100, 100, 783, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAnd = new JButton("and");
		btnAnd.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				andPressed=true;
				if(ok1 || okNot1){
					chooseTime(csvPath);
				}
				else if(ok2 || okNot2){
					chooseId(csvPath);
				}
				else if(ok3 || okNot3){
					chooseLoc(csvPath);
				}
				else if(ok4 || okNot4){
					chooseRad(csvPath);
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
				ok4 = true;
				okNot4 = false;
			}
		});
		chckbxRadiusFilter.setBounds(553, 148, 149, 25);
		contentPane.add(chckbxRadiusFilter);

		JCheckBox chckbxLocationFilter = new JCheckBox("location filter");
		chckbxLocationFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxLocationFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok3 = true;
				okNot3 = false;
			}
		});
		chckbxLocationFilter.setBounds(344, 148, 166, 25);
		contentPane.add(chckbxLocationFilter);

		JButton btnOr = new JButton("or");
		btnOr.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnOr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orPressed=true;
				if(ok1 || okNot1){
					chooseTime(csvPath);
				}
				else if(ok2 || okNot2){
					chooseId(csvPath);
				}
				else if(ok3 || okNot3){
					chooseLoc(csvPath);
				}
				else if(ok4 || okNot4){
					chooseRad(csvPath);
				}

				//	String sub =csvPath.substring(0, csvPath.length()-9);
				//	orFil orfil=new orFil();
				/*	if(ok1){
					orfil.readFolder(sub, "time.csv");
				}
				if(ok2){
					orfil.readFolder(sub, "id.csv");
				}
				if(ok3){
					orfil.readFolder(sub, "loc.csv");
				}
				if(ok4){
					orfil.readFolder(sub, "rad.csv");
				}*/

				/*if(ok1 || okNot1){
					chooseTime(csvPath);
				}
				else if(ok2 || okNot2){
					chooseId(csvPath);
				}
				else if(ok3 || okNot3){
					chooseLoc(csvPath);
				}
				else if(ok4 || okNot4){
					chooseRad(csvPath);
				}*/
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
				okNot4 = true;
				ok4 = false;
			}
		});
		chckbxRadiusnotFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxRadiusnotFilter.setBounds(553, 190, 186, 25);
		contentPane.add(chckbxRadiusnotFilter);

		JCheckBox chckbxLocationnotFilter = new JCheckBox("locationNot filter");
		chckbxLocationnotFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okNot3 = true;
				ok3 = false;
			}
		});
		chckbxLocationnotFilter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxLocationnotFilter.setBounds(344, 188, 198, 25);
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

/*andButton
 * //if the time filter is chosen
				if(ok1){
					timeFil tim= new timeFil();
					tim.setCsvPath(csvPath);
					//contentPane.hide();
					tim.setVisible(true);
					tim.hide();

					//id or idNot
					//id
					if(ok2){
						idFil id= new idFil();
						id.setCsvPath(tim.getTimeCsv()); 
						//contentPane.hide();
						id.setVisible(true);
					}
					//idNot
					else if(okNot2){
						idFil idNot= new idFil();
						idNot.setnotFilter(true);
						idNot.setCsvPath(tim.getTimeCsv()); 
						//contentPane.hide();
						idNot.setVisible(true);
					}

					//loc or locNot
					//loc
					else if(ok3){
						locFil loc= new locFil();
						loc.setCsvPath(tim.getTimeCsv()); 
						//contentPane.hide();
						loc.setVisible(true);
					}
					//locNot
					else if(okNot3){
						locFil locNot= new locFil();
						locNot.setnotFilter(true);
						locNot.setCsvPath(tim.getTimeCsv()); 
						//contentPane.hide();
						locNot.setVisible(true);
					}

					//rad or radNot
					//rad
					else if(ok4){
						radFil rad= new radFil();
						rad.setCsvPath(tim.getTimeCsv());
						//contentPane.hide();
						rad.setVisible(true);
					}
					//radNot
					else if(okNot4){
						radFil radNot= new radFil();
						radNot.setnotFilter(true);
						radNot.setCsvPath(tim.getTimeCsv()); 
						//contentPane.hide();
						radNot.setVisible(true);
					}
					contentPane.hide();
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
				}*/



/*orButton
 * //if the time filter is chosen
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

				//if the id filter is chosen (and the time isn't)
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

				//if the loc filter is chosen(and the time+id aren't)
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

				//if the rad filter is chosen(and the time+id+loc aren't)
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
 */

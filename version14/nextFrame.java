package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class nextFrame extends JFrame {
	
	
	private JPanel contentPane;
	private String csvPath;
	private String wigglePath;
	private JTextField ip;
	private JTextField port;
	private JTextField database;
	private JTextField username;
	private JTextField password;
	private JTextField table;

	
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
					nextFrame frame = new nextFrame();
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
	public nextFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 671);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		csvPath = getCsvPath();
		wigglePath = getWigPath();

		JButton btnAlgo = new JButton("Algorithms");
		btnAlgo.setForeground(Color.RED);
		btnAlgo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					algorithmOneTwo alg= new algorithmOneTwo();
					alg.setCsvPath(csvPath);
					alg.setWigPath(wigglePath);
					
					contentPane.hide();
					alg.setVisible(true);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in algorithm button");
				}
			}
		});
		btnAlgo.setBounds(25, 87, 153, 99);
		contentPane.add(btnAlgo);
		
		
		JButton button_1 = new JButton("Filters");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					filters flt= new filters();
					flt.setCsvPath(csvPath);
					flt.setWigPath(wigglePath);
					contentPane.hide();
					flt.setVisible(true);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in filter button");
				}
			}
		});
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBackground(UIManager.getColor("Button.highlight"));
		button_1.setBounds(203, 86, 147, 100);
		contentPane.add(button_1);
		
		JButton btnDeleteFiles = new JButton("delete files");
		btnDeleteFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					outputTable out ;
					deleteFiles file= new deleteFiles();
					contentPane.hide();
					file.setVisible(true);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in create Files button");
				}
			}
		});
		btnDeleteFiles.setForeground(Color.RED);
		btnDeleteFiles.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDeleteFiles.setBounds(376, 89, 180, 100);
		contentPane.add(btnDeleteFiles);
		
		JLabel label = new JLabel("choose the option you want: ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(117, 35, 347, 42);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("if you want to use data from sql enter the following fileds:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(31, 240, 525, 36);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("enter ip:");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(25, 279, 108, 36);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("enter port:");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(25, 317, 108, 36);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("enter database:");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(25, 448, 187, 36);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("enter username:");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBounds(25, 356, 187, 36);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("enter password:");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_6.setBounds(25, 403, 187, 36);
		contentPane.add(label_6);
		
		JLabel lblEnterTable = new JLabel("enter table:");
		lblEnterTable.setForeground(Color.RED);
		lblEnterTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterTable.setBounds(25, 490, 108, 36);
		contentPane.add(lblEnterTable);
		
		JButton button = new JButton("USE SQL");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputTable temp= new outputTable();
				if(!ip.getText().isEmpty() && !port.getText().isEmpty() && 
					!username.getText().isEmpty() &&  !password.getText().isEmpty() &&  
					!database.getText().isEmpty() &&	!table.getText().isEmpty()){
				temp.setDataSql(ip.getText(), Integer.parseInt(port.getText()), 
						username.getText(), password.getText(), database.getText(),
						table.getText());
				temp.setUrl(ip.getText(), Integer.parseInt(port.getText()), database.getText());
				temp.setUsername(username.getText());
				temp.setPassword(password.getText());
				
				}
				//jdbc:mysql://"+5.29.193.52+":3306/oop_course_ariel
				/*System.out.println("ip= "+ ip.getText());
				System.out.println("port= "+ Integer.parseInt(port.getText()));
				System.out.println("username = "+ username.getText());
				System.out.println("password= "+ password.getText());
				System.out.println("database= "+ database.getText());
				System.out.println("table= "+ table.getText());*/
			/*	System.out.println(temp.getUrl());
				System.out.println(temp.getUsername());
				System.out.println(temp.getPassword());*/
				//System.out.println();
				try {
					temp.read_mysql(csvPath);
					//temp.read(csvPath, true);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//temp.read_mysql();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button.setBounds(203, 563, 142, 36);
		contentPane.add(button);
		
		ip = new JTextField();
		ip.setColumns(10);
		ip.setBounds(204, 286, 146, 26);
		contentPane.add(ip);
		
		port = new JTextField();
		port.setColumns(10);
		port.setBounds(204, 324, 146, 26);
		contentPane.add(port);
		
		database = new JTextField();
		database.setText("");
		database.setColumns(10);
		database.setBounds(203, 455, 146, 26);
		contentPane.add(database);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(203, 363, 146, 26);
		contentPane.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(203, 406, 146, 26);
		contentPane.add(password);
		
		table = new JTextField();
		table.setColumns(10);
		table.setBounds(203, 500, 146, 26);
		contentPane.add(table);
		
		
	}
}

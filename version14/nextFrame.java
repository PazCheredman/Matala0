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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class nextFrame extends JFrame {
	
	
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
		setBounds(100, 100, 605, 309);
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
		
		
	}
}

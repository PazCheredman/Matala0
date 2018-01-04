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

	/*
	Algorithm = new JButton("Algorithm");
	Algorithm.setBackground(UIManager.getColor("Button.highlight"));
	Algorithm.setForeground(Color.RED);
	Algorithm.setFont(new Font("Tahoma", Font.PLAIN, 20));
	Algorithm.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try{
				algorithmOneTwo alg= new algorithmOneTwo();
				frame.dispose();
				alg.setVisible(true);
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "error in algorithm button");
			}
		}
	});
	Algorithm.setBounds(96, 309, 147, 100);
	frame.getContentPane().add(Algorithm);

	filter = new JButton("Filters");
	filter.setBackground(UIManager.getColor("Button.highlight"));
	filter.setForeground(Color.RED);
	filter.setFont(new Font("Tahoma", Font.PLAIN, 20));
	filter.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try{
				filters flt= new filters();
				frame.dispose();
				flt.setVisible(true);
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "error in filter button");
			}
		}
	});
	filter.setBounds(311, 309, 147, 100);
	frame.getContentPane().add(filter);

	createFiles = new JButton("create files");
	createFiles.setForeground(Color.RED);
	createFiles.setFont(new Font("Tahoma", Font.PLAIN, 20));
	createFiles.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try{
				createFiles file= new createFiles();
				frame.dispose();
				file.setVisible(true);
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "error in create Files button");
			}
		}
	});
	createFiles.setBounds(561, 309, 180, 100);
	frame.getContentPane().add(createFiles);
*/	
	
	
	private JPanel contentPane;

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
		
		
		/*
		JButton button = new JButton("Algorithm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					algorithmOneTwo alg= new algorithmOneTwo();
					contentPane.hide();
					alg.setVisible(true);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in algorithm button");
				}
			}
		});
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBackground(Color.WHITE);
		button.setBounds(15, 89, 147, 100);
		contentPane.add(button);
		*/
		
		JButton btnAlgo = new JButton("algo");
		btnAlgo.setForeground(Color.RED);
		btnAlgo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					algorithmOneTwo alg= new algorithmOneTwo();
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

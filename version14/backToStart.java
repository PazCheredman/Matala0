package version14;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class backToStart extends JFrame {

	private JPanel contentPane;
	private JTextField enterPathWiggle;
	private JTextField enterPathCsvKml;
	private mainRun tableCsv= new mainRun();
	private mainRun tableKml= new mainRun();
	private JButton btnOk;
	private JButton button;
	private boolean ok1=false,ok2=false;
	private JButton btnNext;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					backToStart frame = new backToStart();
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
	public backToStart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("please enter path of folder that contains wiggle wifi application files:");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(30, 84, 635, 36);
		contentPane.add(label);

		enterPathWiggle = new JTextField();
		enterPathWiggle.setColumns(10);
		enterPathWiggle.setBounds(56, 153, 461, 42);
		contentPane.add(enterPathWiggle);

		JButton button = new JButton("ok");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path;
				try{
					if(!enterPathWiggle.getText().isEmpty()){
						path=enterPathWiggle.getText();
						ok1=true;
						//	JOptionPane.showMessageDialog(null, "ok input of wiggle button");
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of wiggle button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of wiggle button");
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button.setBounds(562, 156, 115, 29);
		contentPane.add(button);

		JLabel label_1 = new JLabel("please enter path of other folder that you want to put the csv and kml files in it");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(30, 230, 713, 36);
		contentPane.add(label_1);

		enterPathCsvKml = new JTextField();
		enterPathCsvKml.setColumns(10);
		enterPathCsvKml.setBounds(56, 287, 461, 42);
		contentPane.add(enterPathCsvKml);

		JButton button_1 = new JButton("ok");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path;
				try{
					if(!enterPathCsvKml.getText().isEmpty()){
						path=enterPathCsvKml.getText();
						ok2=true;
						tableCsv.init(enterPathWiggle.getText(), enterPathCsvKml.getText(), "gmon.csv");
						// JOptionPane.showMessageDialog(null, "ok input of CsvKml button");
					}
					else{
						JOptionPane.showMessageDialog(null, "ok input of CsvKml button null");

					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input of CsvKml button");				}
			}
	});

		button_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_1.setBounds(562, 290, 115, 29);
		contentPane.add(button_1);

		JButton button_2 = new JButton("next");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(ok1 && ok2){
						nextFrame next= new nextFrame();
						tableKml.initiliaze(enterPathCsvKml.getText(), "gmon.csv");
						contentPane.hide();
						next.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "please enter paths to text boxes above");

					}

				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "error in input ok1,ok2 buttons");
				}
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_2.setBounds(255, 359, 142, 36);
		contentPane.add(button_2);
}

}

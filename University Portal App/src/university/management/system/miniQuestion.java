package university.management.system;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class miniQuestion {

	public JFrame frame;
	private JTextField textField;
	JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miniQuestion window = new miniQuestion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public miniQuestion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 721, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Question : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(31, 31, 129, 29);
		frame.getContentPane().add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(144, 37, 526, 249);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("ANSWER :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(31, 320, 103, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(144, 320, 526, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacher_classroom.Answer=textField.getText();
				teacher_classroom.Question=textArea.getText();
				classroom.q = textArea.getText();
				frame.setVisible(false);
				try {
					  File myObj = new File("D:\\College\\Projects\\Mine\\University Portal\\inClassQuestion\\question.txt");
					  File myObj1 = new File("D:\\College\\Projects\\Mine\\University Portal\\inClassQuestion\\answer.txt");
				      if (myObj.createNewFile()) {
				        System.out.println("File created: " + myObj.getName());
				      } else {
				        System.out.println("File already exists.");
				      }
				      if (myObj1.createNewFile()) {
					        System.out.println("File created: " + myObj1.getName());
				      } else {
				        System.out.println("File already exists.");
				      }
				      FileWriter myWriter = new FileWriter("D:\\College\\Projects\\Mine\\University Portal\\inClassQuestion\\question.txt");
				      FileWriter myWriter1 = new FileWriter("D:\\College\\Projects\\Mine\\University Portal\\inClassQuestion\\answer.txt");
				      myWriter.write(teacher_classroom.Question);
				      myWriter1.write(teacher_classroom.Answer);
				      myWriter.close();
				      myWriter1.close();
				      System.out.println("Successfully wrote to the file.");
				    } catch (IOException ee) {
				      System.out.println("An error occurred.");
				      ee.printStackTrace();
				    }
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(268, 374, 149, 35);
		frame.getContentPane().add(btnNewButton);
	}

}

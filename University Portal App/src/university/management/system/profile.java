package university.management.system;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("unused")
public class profile extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	/**
	 * @wbp.nonvisual location=683,-16
	 */
	@SuppressWarnings("unused")
	private final JLabel label = new JLabel("New label");
	private JTextField name;
	private JTextField father_name;
	private JTextField age;
	private JTextField rolln;
	private JTextField course;
	private JTextField dob;
	private JTextField branch;
	private JTextField aadhar;
	private JTextField class12;
	private JTextField email;
	private JTextField class10;
	private JTextField phone;
	String roll;
	String r=Project.roll_no;
	String a;
	String r1=Project.roll_no1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		profile window = new profile();
	}

	/**
	 * Create the application.
	 */
	public profile() {
		roll=r;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(450, 50, 726, 723);
		frame.getContentPane().setLayout(new MigLayout("", "[344px][349px]", "[43px][43px][43px][43px][43px][43px][43px][43px][43px][43px][43px][43px][43px][48px]"));
		frame.setVisible(true);
		JLabel Profile = new JLabel("PROFILE");
		Profile.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 27));
		frame.getContentPane().add(Profile, "cell 0 0 2 1,alignx center,aligny baseline");
		
		JLabel NAME = new JLabel("NAME");
		NAME.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(NAME, "cell 0 1,grow");
		
		name = new JTextField();
		name.setEditable(false);
		frame.getContentPane().add(name, "cell 1 1,grow");
		name.setColumns(10);
		
		JLabel FATHER_NAME = new JLabel("FATHER NAME");
		FATHER_NAME.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(FATHER_NAME, "cell 0 2,grow");
		
		father_name = new JTextField();
		father_name.setEditable(false);
		frame.getContentPane().add(father_name, "cell 1 2,grow");
		father_name.setColumns(10);
		
		JLabel ROLL_NUMBER = new JLabel("ROLL NUMBER");
		frame.getContentPane().add(ROLL_NUMBER, "cell 0 3,grow");
		
		rolln = new JTextField();
		rolln.setEditable(false);
		frame.getContentPane().add(rolln, "cell 1 3,grow");
		rolln.setColumns(10);
		
		JLabel DOB = new JLabel("DATE OF BIRTH");
		frame.getContentPane().add(DOB, "cell 0 4,grow");
		
		dob = new JTextField();
		dob.setEditable(false);
		frame.getContentPane().add(dob, "cell 1 4,grow");
		dob.setColumns(10);
		
		JLabel BRANCH = new JLabel("BRANCH");
		frame.getContentPane().add(BRANCH, "cell 0 5,grow");
		
		branch = new JTextField();
		branch.setEditable(false);
		frame.getContentPane().add(branch, "cell 1 5,grow");
		branch.setColumns(10);
		
		JLabel COURSE = new JLabel("COURSE");
		frame.getContentPane().add(COURSE, "cell 0 6,grow");
		
		course = new JTextField();
		course.setEditable(false);
		frame.getContentPane().add(course, "cell 1 6,grow");
		course.setColumns(10);
		
		JLabel AGE = new JLabel("AGE");
		frame.getContentPane().add(AGE, "cell 0 7,grow");
		
		age = new JTextField();
		age.setEditable(false);
		frame.getContentPane().add(age, "cell 1 7,grow");
		age.setColumns(10);
		
		JLabel AADHAR = new JLabel("AADHAR");
		frame.getContentPane().add(AADHAR, "cell 0 8,grow");
		
		aadhar = new JTextField();
		aadhar.setEditable(false);
		frame.getContentPane().add(aadhar, "cell 1 8,grow");
		aadhar.setColumns(10);
		
		JLabel CLASS_XII = new JLabel("CLASS XII");
		frame.getContentPane().add(CLASS_XII, "cell 0 9,grow");
		
		class12 = new JTextField();
		class12.setEditable(false);
		frame.getContentPane().add(class12, "cell 1 9,grow");
		class12.setColumns(10);
		
		JLabel CLASS_X = new JLabel("CLASS X");
		frame.getContentPane().add(CLASS_X, "cell 0 10,grow");
		
		class10 = new JTextField();
		class10.setEditable(false);
		frame.getContentPane().add(class10, "cell 1 10,grow");
		class10.setColumns(10);
		
		JLabel EMAIL = new JLabel("EMAIL");
		frame.getContentPane().add(EMAIL, "cell 0 11,grow");
		
		email = new JTextField();
		email.setEditable(false);
		frame.getContentPane().add(email, "cell 1 11,grow");
		email.setColumns(10);
		
		JLabel PHONE = new JLabel("PHONE");
		frame.getContentPane().add(PHONE, "cell 0 12,grow");
		
		phone = new JTextField();
		phone.setEditable(false);
		frame.getContentPane().add(phone, "cell 1 12,grow");
		phone.setColumns(10);
		
		JLabel ADDRESS = new JLabel("ADDRESS");
		frame.getContentPane().add(ADDRESS, "cell 0 13,grow");
		
		JTextPane adress = new JTextPane();
		adress.setEditable(false);
		frame.getContentPane().add(adress, "cell 1 13,grow");
		
		JButton b1=new JButton("Print");
		frame.getContentPane().add(b1,"South");
        
        b1.addActionListener(this);
		
		
		
		if(r1!=null) {
		  try{
              conn con = new conn();
              String str = "select * from student where rollno = '"+r1+"'";
              ResultSet rs = con.s.executeQuery(str);

              if(rs.next()){
                
                  name.setText(rs.getString(1));
                  father_name.setText(rs.getString(2));
                  age.setText(rs.getString(3));
                  dob.setText(rs.getString(4));
                  adress.setText(rs.getString(5));
                  phone.setText(rs.getString(6));
                  email.setText(rs.getString(7));
                  class10.setText(rs.getString(8));
                  class12.setText(rs.getString(9));
                  aadhar.setText(rs.getString(10));
                  rolln.setText(rs.getString(11));
                  course.setText(rs.getString(12));
                  branch.setText(rs.getString(13));
              }

              
          }catch(Exception e){}  
		}
		else if(r!=null) {
			  try{
				  ROLL_NUMBER.setText("EMPLOYEE ID");
	              conn con = new conn();
	              String str = "select * from teacher where emp_id = '"+r+"'";
	              ResultSet rs = con.s.executeQuery(str);

	              if(rs.next()){
	                
	                  name.setText(rs.getString(1));
	                  father_name.setText(rs.getString(2));
	                  age.setText(rs.getString(3));
	                  dob.setText(rs.getString(4));
	                  adress.setText(rs.getString(5));
	                  phone.setText(rs.getString(6));
	                  email.setText(rs.getString(7));
	                  class10.setText(rs.getString(8));
	                  class12.setText(rs.getString(9));
	                  aadhar.setText(rs.getString(10));
	                  course.setText(rs.getString(11));
	                  rolln.setText(rs.getString(12));
	                  branch.setText(rs.getString(13));
	              }

	              
	          }catch(Exception e){}  
			}
		    
      }

	@Override
	public void actionPerformed(ActionEvent e) {
		 try{
	            frame.print(null);
	        }catch(Exception ex){}
		
	}
		
		
		
	}


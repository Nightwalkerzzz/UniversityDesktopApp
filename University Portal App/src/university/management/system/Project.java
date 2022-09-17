package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar mb  = new JMenuBar();
	static String roll_no=null;
	static String roll_no1=null;
	
    public Project(int c){
        super("University Management System------ADMIN");
        setSize(1530,860);
        
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/third1.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1530, 860,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);
        
           master(0);
	       user(0);
	       attendance(0);
	       attendance_detail(0);
	       exam(0);
	       report(0);
	       fee(1);
	       utility();
	       //classroom()
	       notice(0);
	       exit();
	       about();

        setJMenuBar(mb);   
        
        mb.setLayout(new GridLayout(1,1));
        setFont(new Font("Senserif",Font.BOLD,16));
        //setLayout(new FlowLayout());
        setVisible(true);
    }
    
    
    public Project(int a,int b){
    	super("University Management System------STUDENT");
        
        setSize(1530,860);
        
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/third.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1530, 860,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);
        report(1);
	    attendance_detail(1);
	    exam(1);
	    fee(0);
	    utility();
	    notice(2);
	    Sclassroom();
	    profile();
	    exit();
	    about();
	       
        setJMenuBar(mb);    
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
    }
    
    public Project(int i, int j, int k) {
    	super("University Management System------TEACHER");
        
        setSize(1530,860);
        
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/third.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1530, 860,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);
           master(2);
           user(1);
	       attendance(1);
	       attendance_detail(0);
	       exam(0);
	       report(0);
	       fee(1);
	       utility();
	       notice(0);
	       Tclassroom();
	       profile();
	       exit();
	       about();
	       
        setJMenuBar(mb);    
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
	}
    
    public void profile() {
    	JMenu profile = new JMenu("Profile");
    	JMenuItem pro = new JMenuItem("Profile");
        profile.setForeground(Color.RED);
        
        pro.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/second.jpg"));
        Image image11 = icon11.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        pro.setIcon(new ImageIcon(image11));
        pro.setMnemonic('S');
        pro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        pro.setBackground(Color.WHITE);
        
        pro.addActionListener(this);
        profile.add(pro);
     
        mb.add(profile);
    }
	public void exit() {
    	JMenu exit = new JMenu("Exit");
        JMenuItem ex = new JMenuItem("Exit");
        exit.setForeground(Color.RED);
        
        ex.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon12.png"));
        Image image11 = icon11.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image11));
        ex.setMnemonic('T');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);
        
        ex.addActionListener(this);
        exit.add(ex);
     
        mb.add(exit);
    }
    public void master(int a) {
    	 JMenu master = new JMenu("Master");
         JMenuItem m1 = new JMenuItem("New Faculty");
         JMenuItem m2 = new JMenuItem("New Student Admission");
         master.setForeground(Color.BLUE);
         
         m1.setFont(new Font("monospaced",Font.BOLD,16));
         ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon1.png"));
         Image image1 = icon1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
         m1.setIcon(new ImageIcon(image1));
         m1.setMnemonic('A');
         m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
         m1.setBackground(Color.WHITE);
         
         m2.setFont(new Font("monospaced",Font.BOLD,16));
         ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon2.png"));
         Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
         m2.setIcon(new ImageIcon(image2));
         m2.setMnemonic('B');
         m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
         m2.setBackground(Color.WHITE);
         
     
         if(a==0) {
        	 m1.addActionListener(this);  
             master.add(m1);
             m2.addActionListener(this);
        	 master.add(m2);
         }
         if(a==1) {
        	 m1.addActionListener(this);  
             master.add(m1);
         }
         if(a==2) {
        	 m2.addActionListener(this);
        	 master.add(m2);
         }
         mb.add(master);
    }
    public void notice(int a) {
   	 	JMenu notice = new JMenu("Notice");
        JMenuItem m1 = new JMenuItem("New Notice");
        JMenuItem m2 = new JMenuItem("All Notice");
        notice.setForeground(Color.BLUE);
        
        m1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon4.jpg"));
        Image image1 = icon1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        m1.setIcon(new ImageIcon(image1));
        m1.setMnemonic('A');
        m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        m1.setBackground(Color.WHITE);
        
        m2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon8.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m2.setIcon(new ImageIcon(image2));
        m2.setMnemonic('B');
        m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        m2.setBackground(Color.WHITE);
        
    
        if(a==0) {
       	 m1.addActionListener(this);  
           notice.add(m1);
            m2.addActionListener(this);
       	 notice.add(m2);
        }
        if(a==1) {
       	 m1.addActionListener(this);  
            notice.add(m1);
        }
        if(a==2) {
       	 m2.addActionListener(this);
       	 notice.add(m2);
        }
        mb.add(notice);
   }
    public void user(int a) {

        JMenu user = new JMenu("Details");
        JMenuItem u1 = new JMenuItem("Student Details");
        JMenuItem u2 = new JMenuItem("Teacher Details");
        user.setForeground(Color.RED);
        
        u1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon3.png"));
        Image image4 = icon4.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        u1.setIcon(new ImageIcon(image4));
        u1.setMnemonic('C');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        u1.setBackground(Color.WHITE);
        
        u2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon4.jpg"));
        Image image5 = icon5.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        u2.setIcon(new ImageIcon(image5));
        u2.setMnemonic('D');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        u2.setBackground(Color.WHITE);
        
        
        if(a==0) {
        	u1.addActionListener(this);
            u2.addActionListener(this);
            user.add(u1);
            user.add(u2);
        }if(a==1) {
        	u1.addActionListener(this);
        	user.add(u1);
        }if(a==2) {
        	u2.addActionListener(this);
        	user.add(u2);
        }
    	mb.add(user);
    }
    public void attendance(int a) {
    	 
        JMenu attendance = new JMenu("Attendance");
        JMenuItem a1 = new JMenuItem("Student Attendance");
        JMenuItem a2 = new JMenuItem("Teacher Attendance");
        attendance.setForeground(Color.BLUE);
        
        a1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon23 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon14.jpg"));
        Image image24 = icon23.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        a1.setIcon(new ImageIcon(image24));
        a1.setMnemonic('E');
        a1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        a1.setBackground(Color.WHITE);
               
        a2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon25 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon15.png"));
        Image image26 = icon25.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        a2.setIcon(new ImageIcon(image26));
        a2.setMnemonic('F');
        a2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK));
        a2.setBackground(Color.WHITE);
        
        a1.addActionListener(this);
        a2.addActionListener(this);
        if (a==0) {
        	attendance.add(a1);
            attendance.add(a2);
		}if (a==1) {
			attendance.add(a1);
		}if (a==2) {
			 attendance.add(a2);
		}
        
        
    	 mb.add(attendance);
    }
    public void attendance_detail(int a) {
    	 
        JMenu attendance_detail = new JMenu("Attendance Detail");
        JMenuItem b1 = new JMenuItem("Student Attendance Detail");
        JMenuItem b2 = new JMenuItem("Teacher Attendance Detail");
        attendance_detail.setForeground(Color.RED);
        
        b1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon27 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon15.png"));
        Image image28 = icon27.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        b1.setIcon(new ImageIcon(image28));
        b1.setMnemonic('G');
        b1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
        b1.setBackground(Color.WHITE);
              
        b2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon29 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon14.jpg"));
        Image image30 = icon29.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        b2.setIcon(new ImageIcon(image30));
        b2.setMnemonic('H');
        b2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        b2.setBackground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        if (a==0) {
        	attendance_detail.add(b1);
            attendance_detail.add(b2);
		}if (a==1) {
			attendance_detail.add(b1);
		}if (a==2) {
			 attendance_detail.add(b2);
		}
        
        
        
    	 mb.add(attendance_detail);
}
    public void exam(int a) {

        
        JMenu exam = new JMenu("Examination");
        JMenuItem c1 = new JMenuItem("Examination Details");
        JMenuItem c2 = new JMenuItem("Enter Marks");
        exam.setForeground(Color.BLUE);
        
        c1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon30 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon16.png"));
        Image image31 = icon30.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        c1.setIcon(new ImageIcon(image31));
        c1.setMnemonic('I');
        c1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        c1.setBackground(Color.WHITE);
               
        c2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon32 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon17.png"));
        Image image33 = icon32.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        c2.setIcon(new ImageIcon(image33));
        c2.setMnemonic('J');
        c2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        c2.setBackground(Color.WHITE);
        
        c1.addActionListener(this);
        c2.addActionListener(this);
        
        if (a==0) {
        	exam.add(c1);
            exam.add(c2);
		}if (a==1) {
			exam.add(c1);
		}if (a==2) {
			exam.add(c2);
		}
        
    	 mb.add(exam);
}
    public void report(int a) {
    	  JMenu report = new JMenu("Update Details");
          JMenuItem r1 = new JMenuItem("Update Students");
          JMenuItem r2 = new JMenuItem("Update Teachers");
          report.setForeground(Color.RED);
          
          r1.setFont(new Font("monospaced",Font.BOLD,16));
          ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon5.png"));
          Image image7 = icon7.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
          r1.setIcon(new ImageIcon(image7));
          r1.setMnemonic('K');
          r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
          r1.setBackground(Color.WHITE);
              
          r2.setFont(new Font("monospaced",Font.BOLD,16));
          ImageIcon iconn = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon6.png"));
          Image imagee = iconn.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
          r2.setIcon(new ImageIcon(imagee));
          r2.setMnemonic('L');
          r2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
          r2.setBackground(Color.WHITE);
          
          if (a==0) {
        	  r1.addActionListener(this);
              r2.addActionListener(this);
              report.add(r1);
              report.add(r2);
          }if (a==1) {
        	  r1.addActionListener(this);
        	  report.add(r1);
          }if (a==2) {
        	  r2.addActionListener(this);
        	  report.add(r2);
          }
          
    	 mb.add(report);
}
    public void fee(int a) {
    	JMenu fee = new JMenu("Fee Details");
        JMenuItem s1 = new JMenuItem("Fee Structure");
        JMenuItem s2 = new JMenuItem("Student Fee Form");
        JMenuItem s3 = new JMenuItem("List");
        fee.setForeground(Color.BLUE);
        
        s1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon14 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon7.png"));
        Image image15 = icon14.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        s1.setIcon(new ImageIcon(image15));
        s1.setMnemonic('M');
        s1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        s1.setBackground(Color.WHITE);
               
        s2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon16 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon8.png"));
        Image image17 = icon16.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        s2.setIcon(new ImageIcon(image17));
        s2.setMnemonic('N');
        s2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        s2.setBackground(Color.WHITE);
        
        s3.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon18 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon17.png"));
        Image image18 = icon18.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        s3.setIcon(new ImageIcon(image18));
        s3.setMnemonic('z');
        s3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        s3.setBackground(Color.WHITE);
        
        
        
        
        s1.addActionListener(this);
        s2.addActionListener(this);
        fee.add(s1);
        fee.add(s2);
        if(a ==1) {
        	s3.addActionListener(this);
            fee.add(s3);
        }
        
    	  mb.add(fee);
}
    public void utility() {
    	  JMenu utility = new JMenu("Utility");
          JMenuItem ut1 = new JMenuItem("Notepad");
          JMenuItem ut2 = new JMenuItem("Calculator");
          JMenuItem ut3 = new JMenuItem("Web Browser");
          utility.setForeground(Color.RED); 
          
          ut1.setFont(new Font("monospaced",Font.BOLD,16));
          ImageIcon icon18 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon9.png"));
          Image image19 = icon18.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
          ut1.setIcon(new ImageIcon(image19));
          ut1.setMnemonic('O');
          ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
          ut1.setBackground(Color.WHITE);
          
          ut2.setFont(new Font("monospaced",Font.BOLD,16));
          ImageIcon icon20 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon10.png"));
          Image image21 = icon20.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
          ut2.setIcon(new ImageIcon(image21));
          ut2.setMnemonic('P');
          ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
          ut2.setBackground(Color.WHITE);
          
          ut3.setFont(new Font("monospaced",Font.BOLD,16));
          ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon11.png"));
          Image image10 = icon10.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
          ut3.setIcon(new ImageIcon(image10));
          ut3.setMnemonic('Q');
          ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
          ut3.setBackground(Color.WHITE);
                 
          ut1.addActionListener(this);
          ut2.addActionListener(this);
          ut3.addActionListener(this);
          utility.add(ut1);
          utility.add(ut2);
          utility.add(ut3);
    	 mb.add(utility);
}
    public void about() {
    	JMenu about = new JMenu("About");
        JMenuItem aboutus = new JMenuItem("About Us");
        about.setForeground(Color.BLUE);
        
        aboutus.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon21 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon13.jpg"));
        Image image22 = icon21.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        aboutus.setIcon(new ImageIcon(image22));
        aboutus.setMnemonic('R');
        aboutus.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        aboutus.setBackground(Color.WHITE);
        
        about.add(aboutus);
        aboutus.addActionListener(this);
        
        
        
    	 mb.add(about);
}
    public void Tclassroom() {
    	JMenu Classroom = new JMenu("Classroom");
        JMenuItem classroom = new JMenuItem("Classroom");
        Classroom.setForeground(Color.BLUE);
        
        classroom.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon21 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon13.jpg"));
        Image image22 = icon21.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        classroom.setIcon(new ImageIcon(image22));
        classroom.setMnemonic('R');
        classroom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        classroom.setBackground(Color.WHITE);
        
        Classroom.add(classroom);
        classroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tcount=-1;
				mainCallerT();
			}
		});
        
        
    	 mb.add(Classroom);
}
    public void Sclassroom() {
    	JMenu Classroom = new JMenu("Classroom");
        JMenuItem classroom = new JMenuItem("Classroom");
        Classroom.setForeground(Color.RED);
        
        classroom.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon21 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon13.jpg"));
        Image image22 = icon21.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        classroom.setIcon(new ImageIcon(image22));
        classroom.setMnemonic('R');
        classroom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        classroom.setBackground(Color.WHITE);
        
        Classroom.add(classroom);
        classroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scount=-1;
				mainCallerS();
			}
		});
        
        
    	 mb.add(Classroom);
}
    
    
    
    
    static int Scount = 0;
	  
    // The method that calls the main() method
    static void mainCallerS()
    {
  
        System.out.println("mainCaller!");
        Scount++;
  
        // Calling the main() only 3 times
        if (Scount < 1) {
  
            // Calling the main() method
        	studentclassroom.main(null);
        }
    }
    
    static int Tcount = 0;
	  
    // The method that calls the main() method
    static void mainCallerT()
    {
  
        System.out.println("mainCaller!");
        Tcount++;
  
        // Calling the main() only 3 times
        if (Tcount < 1) {
  
            // Calling the main() method
        	teacherclassroom.main(null);
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("New Student Admission")){
            new AddStudent().f.setVisible(true);
            
        }else if(msg.equals("New Faculty")){
            new AddTeacher().f.setVisible(true);
            
        }else if(msg.equals("Student Details")){
            new StudentDetails().setVisible(true);
            
        }else if(msg.equals("Teacher Details")){
            new TeacherDetails().setVisible(true);
           
        }
        else if(msg.equals("Update Students")){
            new UpdateStudent().f.setVisible(true);
           
        }
        else if(msg.equals("Update Teachers")){
            new UpdateTeacher().f.setVisible(true);
           
        }
        else if(msg.equals("Fee Structure")){
            new FeeStructure().setVisible(true);
           
        }
        else if(msg.equals("Student Fee Form")){
            new StudentFeeForm().setVisible(true);
           
        }
        else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Web Browser")){
            
            try{
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Exit")){
            System.exit(0);
        }else if(msg.equals("About Us")){
            new AboutUs().setVisible(true);
        }else if(msg.equals("Student Attendance")){
            new StudentAttendance().setVisible(true);
        }else if(msg.equals("Teacher Attendance")){
            new TeacherAttendance().setVisible(true);
        }else if(msg.equals("Student Attendance Detail")){
            new StudentAttendanceDetail().setVisible(true);
        }else if(msg.equals("Teacher Attendance Detail")){
            new TeacherAttendanceDetail().setVisible(true);
        }else if(msg.equals("Examination Details")){
            new ExaminationDetails().setVisible(true);
        }else if(msg.equals("Enter Marks")){
            new EnterMarks().setVisible(true);
        }else if(msg.equals("Profile")) {
        	new profile();
        }else if(msg.equals("List")) {
        	new Feelist().setVisible(true);;
        }else if(msg.equals("New Notice")) {
        	new Notice_writer();
        }else if(msg.equals("All Notice")) {
        	new Notice().setVisible(true);
        }
        
    }
    
    
    public static void main(String[] args){
        new Project(1).setVisible(true);
    }
    
}

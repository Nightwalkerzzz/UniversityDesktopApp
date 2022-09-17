package university.management.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class LoginT extends Login  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LoginT(){
		super();
		setTitle("LOGIN---TEACHER");
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae){
    	if(ae.getSource()==b1) {
        try{
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            
            String q = "select * from login_t where username='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){
                new Project(0,0,0).setVisible(true);
                Project.roll_no=v;
                setVisible(false);
                System.out.println(Project.roll_no);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
                new LoginT();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    	}else if(ae.getSource()==b2) {
    		System.exit(0);
    	}
    }

	public static void main(String[] args) {
		LoginT l = new LoginT();

	}

}

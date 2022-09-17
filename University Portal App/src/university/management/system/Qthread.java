package university.management.system;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Qthread  extends Thread {
//	try {
//	Socket socketClient1 = new Socket("localhost", 2000);
//    BufferedReader reader1 = new BufferedReader(new InputStreamReader(socketClient1.getInputStream()));
//	}catch(Exception e){}
	@Override
	
	   public void run(){
		try{
            String msg = "";
            String msg1= "";
            System.out.println("Brrrrrr");
            while(true){
            	//if((msg = reader.readLine()) != null)textArea.append(msg + "\n");
            	if((msg1 = teacher_classroom.reader1.readLine()) != null)teacher_classroom.textArea_1.append(msg1 + "\n");
            	
            }
//            while(true){
//            	textArea.append(reader.readLine() + "\n");
//            	textArea_1.append(reader1.readLine() + "\n");
//            	//if((msg1 = reader1.readLine()) != null)textArea_1.append(msg1 + "\n");
//            	
//            }
            
//            while((msg1 = reader1.readLine()) != null){
//            	textArea_1.append(msg1 + "\n");
//            }
        }catch(Exception e){}
	   }
}

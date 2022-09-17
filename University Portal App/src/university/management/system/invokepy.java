package university.management.system;

import java.io.IOException;

public class invokepy {

	public static void main(String[] args) throws IOException {
		
		String command = "python /c start python D:\\College\\Projects\\Mine\\University Portal\\Exam_files\\Student_sheet\\Plag_check.py";
		Process p = Runtime.getRuntime().exec(command);

	}

}

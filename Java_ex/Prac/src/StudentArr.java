import java.util.ArrayList;

public class StudentArr {

	ArrayList arr= new ArrayList();
	
	public void addStudent(StudentInfo si) {  //ArrayList에 객체 저장
		arr.add(si);  
	}
	
	public ArrayList getStudent() {   //ArrayList arr 주소 반환
		return arr;
	}
}

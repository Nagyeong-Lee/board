import java.util.ArrayList;

public class StudentArr {
	
	private ArrayList<Student>stdArr = new ArrayList<>();
	
	public void addStudent(Student s) {
		stdArr.add(s);
		//this.stdArr.add(s);
	}
	
	public ArrayList<Student> getStudent(){
		return stdArr;
	}
	
	public void removeStudent(Student s) {  //삭제
		stdArr.remove(s);
	}
	
	private int index=0;
	public int getIndex() {
		return index++;
	}
	
	public void updateStudent(int index, String name, int kor, int eng, int math) {  //수정

		
		stdArr.get(index).setName(name);  //get메소드 Student형
		stdArr.get(index).setKor(kor);
		stdArr.get(index).setEng(eng);
		stdArr.get(index).setMath(math);
		
	
	}

}

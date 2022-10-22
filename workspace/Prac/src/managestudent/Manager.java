package managestudent;

import java.util.ArrayList;

public class Manager {

	ArrayList<Student>arr = new ArrayList<>();
	
	public void addStudent(Student s) {
		arr.add(s);
	}
	
	public ArrayList<Student> getStudent() {
		return arr;
	}
	
	public ArrayList<Student> searchStudent(String name) {
		ArrayList<Student> arrayList= new ArrayList<>();
		for(Student s : arr) {
			if(s.getName().equalsIgnoreCase(name)) {
				arrayList.add(s);
				break;
			}
		}
		return arrayList;
	}
	
	public ArrayList<Student> removeStudent(int id) {
		ArrayList<Student>arrayList = new ArrayList<>();
		for(Student s : arr) {
			if(s.getId()==id) {
				arrayList.add(s);
				arr.remove(s);
				break;
			}
		}
		return arrayList;
	}
	
	public ArrayList<Student> updateStudent(int id,int id2,String name,int kor, int eng,int math,int art) {
		ArrayList<Student>arrayList = new ArrayList<>();
		for(Student s : arr) {
			if(s.getId()==id) {
				arrayList.add(s);
				s.setId(id2);
				s.setName(name);
				s.setKor(kor);
				s.setEng(eng);
				s.setMath(math);
				s.setArt(art);
			}
		}
		return arrayList;
	}
}

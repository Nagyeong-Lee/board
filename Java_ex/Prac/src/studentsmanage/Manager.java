package studentsmanage;

import java.util.ArrayList;

public class Manager {

	private ArrayList<Students>arr = new ArrayList<>();

	public void addStudents(Students s) {
		arr.add(s);
	}

	public ArrayList<Students> getStudents() {
		return arr;
	}

	public Students searchStudents(String name) {
		Students result=null;
		for(Students s : arr) {
			if(name.equals(s.getName())) {
				result=s;
				break;
			}
		}
		return result;
	}
	
	public void removeStudents(int id) {
		for(Students s : arr) {
			if(s.getId()==id) {
				arr.remove(s);
				break;
			}
		}
	}
	
	public Students updateStudents(String name,int id, int kor, int eng, int math) {
		Students result=null;
		for(Students s : arr) {
			if(name.equals(s.getName())) {
				s.setId(id);
				s.setKor(kor);
				s.setEng(eng);
				s.setMath(math);
				result=s;
				break;
				//arr.set(s.getId(), (Students)id);
			}
		}
		return result;
	}

}

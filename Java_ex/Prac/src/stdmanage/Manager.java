package stdmanage;

import java.util.ArrayList;

public class Manager {

	private ArrayList<Student>arrayList = new ArrayList<>();
	
	public void addStudent(Student std) {
		arrayList.add(std);
	}
	
	public ArrayList<Student> getStudent() {
		return arrayList;
	}
	
	public ArrayList<Student> searchStudent(String name){
		ArrayList<Student>arr = new ArrayList<>();
		for(Student std : arrayList) {
			if(name.equalsIgnoreCase(std.getName())) {
				arr.add(std);
				break;
			}
		}
		return arr;
	}
	
	public ArrayList<Student> removeStudent(int id) {
		ArrayList<Student>arr = new ArrayList<>();
		for(Student std : arrayList) {
			if(id==std.getId()) {
				arr.add(std);
				arrayList.remove(std);
				break;
			}
		}
		return arr;
	}
	
	public void updateStudent(int id,String name,int new_id,double kor,double eng,double math,double soc,double sci) {
		for(Student std : arrayList) {
			if(std.getId()==id) {
				std.setName(name);
				std.setId(new_id);
				std.setKor(kor);
				std.setEng(eng);
				std.setMath(math);
				std.setSoc(soc);
				std.setSci(sci);
				break;
			}
		}
	}
}

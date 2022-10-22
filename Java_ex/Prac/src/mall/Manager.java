package mall;

import java.util.ArrayList;

public class Manager {
	
	
	private ArrayList<Member>arr = new ArrayList<>();

	public void addMember(Member m) {
		arr.add(m);
	}
	
	public ArrayList<Member> getMember(){
		return arr;
	}
}

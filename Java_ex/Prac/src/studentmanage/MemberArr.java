package studentmanage;

import java.util.ArrayList;

public class MemberArr {

	private ArrayList arr = new ArrayList();
	
	public void addMember(Member member) {
		arr.add(member);
	}
	
	public ArrayList getMember() {
		return arr;
	}
}

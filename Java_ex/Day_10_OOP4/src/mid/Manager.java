package mid;

import java.util.ArrayList;

public class Manager { //배열,데이터는 Model로 

//	private Silver[]silverMembers = new Silver[10]; //배열도 멤버필드니까 private로
//	private Gold[]goldMembers=new Gold[10];
	
//	private Member[]member=new Member[10];      //부모클래스 Member가 자식클래스 silver,gold 주소 저장OK
    private ArrayList<Member>member = new ArrayList<>();   //Member클래스는 추상클래스라 객체 생성이안되는데
	                                            //이건 객체 생성이아니라 배열만 만든거임

//	private int index=0;   						//ArrayList니까 index필요X
	
	public void addMember(Member m) {  //주소 받고 배열에 저장
//		member[index++]=m;             //silver,gold 둘 다 받음, 오버로딩 필요x
		member.add(m);
//		index++;
	}                          
	
	
	public ArrayList<Member> getMember() { //배열 10개가 아니라 주소 반환
		return member;
	}
	
	
	
//	public int getMemberIndex() { //getter setter은 상속되지만 생성자는 상속안됨
//		return index;
//	}
	
}

package mid;

public abstract class Member{ //부모클래스 :super클래스
					         //silver gold의 공통속성 뽑아서 Member로 만들고 상속
	                         // 추상 클래스 : 객체 생성 못함
							 // 추상 메서드 하나라도 있으면 추상클래스, 추상메서드 상속됨
	                         // Member 클래스는 객체 생성할 일 없어서 ㄱㅊ

	private int id;
	private String name;
	private int point;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public abstract double getBonus();
	
	public Member() {}
	public Member(int id, String name, int point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}
		
	
}

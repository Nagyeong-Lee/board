public class ClassRoom {

	private int desk;
	private int chair;
	private int computer;
	
	
	public int getDesk() {
		return desk;
	}
	public void setDesk(int desk) {
		this.desk = desk;   // this : 암묵적 문법, 자기참조변수 / 생성된 객체의 주소를 저장
	}
	public int getChair() {
		return chair;
	}
	public void setChair(int chair) {
		this.chair = chair;
	}
	public int getComputer() {
		return computer;
	}
	public void setComputer(int computer) {
		this.computer = computer;
	}
	
}

class Monitor{  //Monitor은 참조자료형

	private int price=1000;     //멤버필드
	private String brand="LG";  //멤버필드
	private double weight=25.5; //멤버필드

	public static void powerOn() {  //멤버 메서드, 메서드 안의 변수 = 지역변수  

	}
	void powerOff() {

	}
	void volumeDown() {

	}
	void volumeUp() {

	}

	public Monitor(int price) {  //constructor  
								// 생성자 메서드이름=클래스 이름
								// 생성자 메서드는 return 없음
								// 생성자 메서드는 콜 되는 시점 정해져있음 못바꿈 / 생성자 메서드오버로딩
		this.price=price;
	}
	public Monitor(int price, String brand, double weight) {
		this.price=price;
		this.brand=brand;
		this.weight=weight;
	}
	
	public Monitor() {
		System.out.println("모니터 생성자 실행됨");
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	
}
//class 구성요소 : 멤버필드 멤버메서드 생성자 nested class


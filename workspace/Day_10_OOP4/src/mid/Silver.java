package mid;

public class Silver extends Member{
	
	public Silver(int id,String name,int point) {
		super(id,name,point);  // super()호출 안하고 Member접근제한자 public으로 바꾸면 정보은닉 깨져서안됨
	}
	
	                           //오버라이드 : 부모클래스로부터 상속받은 메소드를 재정의해서 사용
	
	public double getBonus() {      //추상클래스 (abstract) implements
		return this.getPoint()*0.02;
	}
	
}


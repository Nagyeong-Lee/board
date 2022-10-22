package mid;

public class Gold extends Member{   

//	public Gold() {  기본적인 상태
//		super();
//	}
	
	public Gold(int id, String name, int point) {
		super(id,name,point);
	}

	public double getBonus() {
		return this.getPoint()*0.03;
	}
}


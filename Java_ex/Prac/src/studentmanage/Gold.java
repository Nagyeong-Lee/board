package studentmanage;

public class Gold extends Member{
	
	public Gold(int id, String name, int point) {
		super(id,name,point);
	}
	public double getBonus() {
		return getPoint()*0.04;
	}
}

package mall;

public class Gold  extends Member{

	public Gold(int id,String name,int point) {
		super(id,name,point);
	}
	public double getBonus() {
		return super.getPoint()*0.5;
	}
}

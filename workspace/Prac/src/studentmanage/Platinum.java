
package studentmanage;

public class Platinum extends Member{
	
	public Platinum(int id, String name, int point) {
		super(id,name,point);
	}
	public double getBonus() {
		return getPoint()*0.1;
	}
	
}

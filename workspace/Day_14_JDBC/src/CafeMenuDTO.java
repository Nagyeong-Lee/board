
public class CafeMenuDTO {     
	
	//VO : Value Object (값을 저장하는 목적으로 사용되는 객체)
	//DTO : Data Transfer Object (값을 저장하고 전달하는 목적으로 사용되는 객체) 한번에 묶어서 dao에게 전달
	private int pid;
	private String pname;
	private int pprice;
	private String piced;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public String getPiced() {
		return piced;
	}
	public void setPiced(String piced) {
		this.piced = piced;
	}
	
	public CafeMenuDTO() {}
	public CafeMenuDTO(int pid, String pname, int pprice, String piced) {
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.piced = piced;
	}
	

}
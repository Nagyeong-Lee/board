package dto;

public class DTO { 

	private int pid;
	private String pname;
	private int pprice;
	private String iced;
	private String topping;

	public DTO() {}
	public DTO(int pid, String pname, int pprice, String iced, String topping) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.iced = iced;
		this.topping = topping;
	}

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
	public String getIced() {
		return iced;
	}
	public void setIced(String iced) {
		this.iced = iced;
	}
	public String getTopping() {
		return topping;
	}
	public void setTopping(String topping) {
		this.topping = topping;
	}

}

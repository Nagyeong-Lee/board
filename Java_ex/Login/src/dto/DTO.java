package dto;

public class DTO {
	   
	   private String uId;
	   private String Pw;
	   
	   
	   
	   public DTO() {
	      super();
	   }
	   public DTO(String uId, String pw) {
	      this.uId = uId;
	      this.Pw = pw;
	   }
	   public String getuId() {
	      return uId;
	   }
	   public void setuId(String uId) {
	      this.uId = uId;
	   }
	   public String getPw() {
	      return Pw;
	   }
	   public void setPw(String pw) {
	      Pw = pw;
	   }
	  

	}


package bean;

public class School implements java.io.Serializable{
	
	private String name;
	private String cd;

	public String getCd() {
		return cd;
	}
	
	public int getName() {
		return name;
	}
	
	public void setCd(String cd) {
		this.cd=cd;
	}
	
	public void setName(School name) {
		this.name=name;
	}
}    

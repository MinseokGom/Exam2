package bean;

<<<<<<< HEAD
public class School implements java.io.Serializable{
	
	private String name;
	private String cd;

	public String getCd() {
		return cd;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCd(String cd) {
		this.cd=cd;
	}
	
	public void setName(String name) {
		this.name=name;
	}
}    

=======
public class School implements java.io.Serializable {
    
    private String name; // 学校の名前を格納するフィールド
    
    private String cd; // 学校のコードを格納するフィールド
    
    public String getName() {
        return name;
    }
    
    public String getCd() {
        return cd;
    }
    
    public void setName(String name) {
        this.name = name; // 学校の名前を設定
    }
    
    public void setCd(String cd) {
        this.cd = cd; // 学校のコードを設定
    }
}
>>>>>>> branch 'master' of https://github.com/MinseokGom/Exam2.git

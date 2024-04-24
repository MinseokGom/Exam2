package bean;

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

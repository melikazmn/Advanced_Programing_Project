public class User {

    private Enum.User usr;
    private String userName;

    public User(Enum.User usr,String userName) {
        this.usr = usr;
        this.userName = userName;
    }

    public Enum.User getUsr() {
        return usr;
    }

    public void setUsr(Enum.User usr) {
        this.usr = usr;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

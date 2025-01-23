package my.myproject;

import java.util.Date;
/* calss for user data*/
public class UserData {

    private User owner;
    private String app;
    private String username;
    private String password;
    private Date date;
    /*initialization constructor with out parameter*/
    public UserData() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date Date) {
        this.date = Date;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User Owner) {
        this.owner = Owner;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String App) {
        this.app = App;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

}

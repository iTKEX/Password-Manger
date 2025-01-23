package my.myproject;
/* calss for users data list*/
public class User {

    private String name;
    private String username;
    private String password;
    /* initialization constructor with out parameter*/
    public User() {
    }
    /* initialization constructor with out parameter*/
    public User(String name, String userName, String password) {
        this.name = name;
        this.username = userName;
        this.password = password;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
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

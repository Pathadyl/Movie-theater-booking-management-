package model;

public class Admin extends User{
    
    public Admin() {
        super();
    }
    
    public Admin(int id, String userName, String password) {
        super(id, userName, password);
        setRole(Role.ADMIN);
    }

}

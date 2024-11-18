package dto;

import model.Admin;


public class AuthAdminResult extends AuthUserResult {
    private Admin admin;


    public AuthAdminResult(boolean success, String message) {
        super(success, message);
    }

    public AuthAdminResult(Admin admin, boolean success, String message) {
        super(admin, success, message);
    }

    
    
}

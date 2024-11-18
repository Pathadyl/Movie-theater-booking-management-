package service;

import dao.AdminDao;
import model.Admin;
import dto.AuthAdminResult;

public class AuthAdminService {
    
    private AdminDao adminDao;
    
    public AuthAdminService() {
        adminDao = new AdminDao();
    }
    
    public AuthAdminResult authenticateAdmin(String userName, String password) {
        Admin admin = adminDao.findByUsername(userName);
        
        if(admin == null)
            return new AuthAdminResult(false, "Username not found!");
        
        if (admin != null && !admin.getPassword().equals(password))
            return new AuthAdminResult(false, "Incorrect Password!");
        
        return new AuthAdminResult( admin,true, "Login Successful!");
    }
    
}

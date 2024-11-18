package dto;

import model.User;


public abstract class AuthUserResult {
    private User user;
    private boolean success;
    private String message;

    public AuthUserResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    
    public AuthUserResult(User user, boolean success, String message) {
        this.success = success;
        this.message = message;
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    
}

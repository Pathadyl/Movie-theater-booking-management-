package dto;

import model.Member;

public class AuthMemberResult extends AuthUserResult{
    
    private Member member;
 

    public AuthMemberResult(boolean success, String message) {
        super(success, message);
    }

    public AuthMemberResult(Member member, boolean success, String message) {
        super(member, success, message);
    }    
    
}

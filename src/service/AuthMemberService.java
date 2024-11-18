package service;

import dao.MemberDao;
import model.Member;
import dto.AuthMemberResult;

public class AuthMemberService {
    
    private MemberDao memberDao;
    
    public AuthMemberService() {
        memberDao = new MemberDao();
    }
    
    public AuthMemberResult authenticateMember(String userName, String password) {
        Member member = memberDao.findByUsername(userName);
        
        if(member == null)
            return new AuthMemberResult(false, "Username not found!");
        
        if (member != null && !member.getPassword().equals(password))
            return new AuthMemberResult(false, "Incorrect Password!");
        
        return new AuthMemberResult( member,true, "Login Successful!");
    }
    
}

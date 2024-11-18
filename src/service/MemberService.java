package service;

import dao.BillDao;
import dao.MemberDao;
import model.Bill;
import model.Member;

import java.util.List;
import model.Movie;
import model.Theater;

public class MemberService extends CustomerService{
    private BillDao billDao;
    private MemberDao memberDao;
    private Member member;

    public MemberService(Member member) {
        super(member);
        this.member = member;
        billDao = new BillDao();
        memberDao = new MemberDao();
    }

    public List<Bill> getBillList() {
        return billDao.getMemberBillList(getUser().getId());
    }

    public Member getMember() {
        return member;
    }
    
    
    @Override
    public void bookingMovie(String name, String phone, String email, Movie movie, Theater theater, int quantity) {
        double discount = (double) member.getRewardPoint()*1000;
        double total = movie.getPrice()*quantity - discount;
        Bill bill = new Bill(theater.getId(), movie.getId(), quantity, total, discount);
        billDao.addMemberBill(movie.getId(), bill);
        int newRewardPoint = member.getRewardPoint() + quantity;
        memberDao.updateRewardPoint(member.getId(), newRewardPoint);
    }
    
    
    
}

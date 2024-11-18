package service;

import dao.BillDao;
import dao.GuestDao;
import java.util.List;
import model.Bill;
import model.Guest;
import model.Movie;
import model.Theater;

public class GuestService extends CustomerService {
    private BillDao billDao;
    private GuestDao guestDao;

    public GuestService(Guest guest) {
        super(guest);
        guestDao = new GuestDao();
        billDao = new BillDao();
    }
    
    public List<Bill> getBillList() {
        return billDao.getGuestBillList(getUser().getId());
    }

    @Override
    public void bookingMovie(String name, String phone, String email, Movie movie, Theater theater, int quantity) {
        double total = movie.getPrice()*quantity;
        double discount = 0.0;
        Bill bill = new Bill(theater.getId(), movie.getId(), quantity, total, discount);
        billDao.addGuestBill(name, phone, email, bill);
    }
}

package service;

import dao.ShowtimeDao;
import model.Showtime;

public class ShowtimeService {
    private ShowtimeDao showtimedao;
    private Showtime showtime;
    
    
    public ShowtimeService(Showtime showtime){
        showtimedao = new ShowtimeDao();
        this.showtime = showtime;
    }
    
    public boolean updateAvailableSeat(int availableSeat){
        return showtimedao.updateAvailableSeats(showtime.getId(), 0);
    }
}

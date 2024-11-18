import dao.*;
import java.sql.Timestamp;
import model.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        
        MovieDao movieDao = new MovieDao();
        TheaterDao theaterDao = new TheaterDao();
        AdminDao adminDao = new AdminDao();
        MemberDao memberDao = new MemberDao();
        GuestDao guestDao = new GuestDao();
        ShowtimeDao showTimeDao = new ShowtimeDao();


//        List<Movie> movies = movieDao.getMoviesByAvailability(Role.MEMBER, false);
//        for(Movie movie : movies) {
//            System.out.println(movie.getId() + ". " + movie.getTitle());
//        }
//
        List<Theater> theaters = showTimeDao.getTheaterListByMovieIdAndShowtimeDate(1, Timestamp.valueOf("2024-05-13 10:00:00"));
        for(Theater theater : theaters) {
            System.out.println(theater.getId() + ". " + theater.getName());
        }
//
//        Admin admin = adminDao.findByUsername("admin01", "admin01");
//        System.out.println(admin.getId() + ". " + admin.getUserName());
//
//        Member member = memberDao.findByUsername("member1", "abc123");
//        System.out.println("Id: " + member.getId());
//        System.out.println("Name: " + member.getName());
//        System.out.println("Phone: " + member.getPhone());
//        System.out.println("Email: " + member.getEmail());
//        System.out.println("Date of birth: " + member.getDob());
//        System.out.println("Reward point: " + member.getRewardPoint());
//
//        Guest guest = guestDao.createGuest();
//        System.out.println("Id: " + guest.getId());
//        System.out.println("Name: " + guest.getName());
//        System.out.println("Phone: " + guest.getPhone());
//        System.out.println("Email: " + guest.getEmail());
        
       

//        List<Showtime> showtimes = showTimeDao.getShowTimeListByMovie(1);
//        System.out.println("Movie id = 1 has list of show times: ");
//        for(Showtime showtime : showtimes) {
//            System.out.println("id: " + String.valueOf(showtime.getId()));
//            System.out.println("movie_id: " + String.valueOf(showtime.getMovie_id()));
//            System.out.println("theater_id: " + String.valueOf(showtime.getMovie_id()));
//            System.out.println("show_time: " + String.valueOf(showtime.getShowTime()));
//            System.out.println("seats: " + String.valueOf(showtime.getSeats()));
//            
//        }

//          List<Showtime> showtimes = showTimeDao.getShowTimeListByMovieAndTheater(1, 1);
//            for(Showtime showtime : showtimes){
//                System.out.println(showtime.getShowTime());
//            }
    }

}
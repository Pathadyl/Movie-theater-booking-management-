package service;

import dao.MovieDao;
import dao.ShowtimeDao;
import dao.TheaterDao;
import model.Movie;
import model.Theater;
import model.User;
import model.Role;

import java.util.List;
import model.Showtime;

public abstract class UserService {
    private MovieDao movieDao;
    private TheaterDao theaterDao;
    private ShowtimeDao showtimeDao;
    private User user;

    public UserService(User user) {
        this.user = user;
        movieDao = new MovieDao();
        theaterDao = new TheaterDao();
        showtimeDao = new ShowtimeDao();
    }

    public List<Movie> getMovieByAvailability(boolean available) {
        return movieDao.getMoviesByAvailability(user.getRole(), available);
    }
    
    public List<Movie> searchMovieByTitle(String title, Role role) {
        return movieDao.searchMovieByTitle(title, role);
    }


    public List<Movie> getMovieListByGenre(String genre, boolean available){
        return movieDao.getMovieListByGenre(genre, available, user.getRole());
    }

    public List<Movie> getMovieListByTheater(Theater theater) {
        return movieDao.getMovieListByTheater(theater.getId(), user.getRole());
    }

    public Movie getMovieInfo(Movie movie) {
        return movieDao.getMovieById(movie.getId());
    }
    
    public List<Theater> getTheaterListByMovie(Movie movie){
        return showtimeDao.getTheaterListByMovie(movie.getId());
    }

    
    public List<Theater> getAllTheater() {
        return theaterDao.getAllTheaters(user.getRole());
    }

    public List<Showtime> getShowTimeListByMovie(Movie movie){
        return showtimeDao.getShowTimeListByMovie(movie.getId());
    }
    
    public List<Showtime> getShowTimeListByMovieAndTheater(Movie movie, Theater theater) {
        return showtimeDao.getShowTimeListByMovieAndTheater(movie.getId(), theater.getId());
    }

    public MovieDao getMovieDao() {
        return movieDao;
    }
    public TheaterDao getTheaterDao() {
        return theaterDao;
    }
    public User getUser() {
        return user;
    }
}

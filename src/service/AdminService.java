package service;

import dao.AdminDao;
import dao.MovieDao;
import model.Admin;
import model.Movie;
import model.Theater;
import model.User;

import java.util.List;
import model.Role;

public class AdminService extends UserService {
    private AdminDao adminDao;
    private Admin admin;
    
    public AdminService(Admin admin) {
        super(admin);
        adminDao = new AdminDao();
        this.admin = admin;
    }

    // ================================ Admin Management ===================================
    public List<Admin> getAllAdmin() {
        return adminDao.getAllAdmin();
    }
    
    public List<Movie> getAllMovie() {
        return getMovieDao().getAllMovies();
    }
    
    // ================================ Movie Management ===================================
    public boolean addMovieToDB(Movie movie) {
        return getMovieDao().addMovieToDB(movie.getTitle(), movie.getDescription(), movie.getDirector(), movie.getGenre(),
                              movie.getDuration(), movie.getPrice(), movie.getPosterPath(), movie.getCoverPath(),
                              movie.isVisibility(), movie.isAvailability());

    }

    public Movie getMovieById(int id){
        return getMovieDao().getMovieById(id);
    }

    public boolean deleteMovieFromDB(int id){
        return getMovieDao().deleteMovieFromDB(id);
    }

    public boolean editMovieInDB(int id, String title, String description,                   // Edit movie function, when getting the data from UI,
                                 String director, String genre, String duration,             // pass the value into this function
                                 double price,String posterPath, String coverPath,
                                 boolean visibility, boolean availability){
        System.out.println("editing movie ID: "+id);
        return getMovieDao().editMovieFromDB(id,title,description,director, genre, duration,
                price, posterPath, coverPath, visibility, availability);
    }
    

    // ================================ Theater Management ===================================

    public List<Theater> getAllTheater(){
        return getTheaterDao().getAllTheaters(admin.getRole());
    }

    public Theater getTheaterByID(int id){
        return getTheaterDao().getTheaterByID(id);
    }

    public boolean addTheaterToDB(String name, String location, boolean visibility, String avatar_path, String image_path){
        return getTheaterDao().addTheaterToDB(name, location, visibility,avatar_path, image_path);
    }

    public boolean deleteTheater(int id){
        return getTheaterDao().removeTheaterFromDB(id);
    }

    public boolean updateTheater(int id, String name, String location, boolean visibility, String avatar_path, String image_path){
        return getTheaterDao().editTheaterFromDB(id,name, location, visibility, avatar_path, image_path);
    }
}
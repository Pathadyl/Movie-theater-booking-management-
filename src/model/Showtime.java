package model;

import java.sql.Timestamp;

public class Showtime {
    private int id;
    private int movie_id;
    private int theater_id;
    private Timestamp showTime;
    private int seats;
    private int available;

    public Showtime(int id, int movie_id, int theater_id, Timestamp showTime, int seats, int available) {
        this.id = id;
        this.movie_id = movie_id;
        this.theater_id = theater_id;
        this.showTime = showTime;
        this.seats = seats;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public Timestamp getShowTime() {
        return showTime;
    }

    public int getSeats() {
        return seats;
    }

    public int getAvailable() {
        return available;
    }

    
    
    
    
    


}

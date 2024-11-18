package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Bill {
    private int id;
    private int theaterId;
    private int movieId;
    private Timestamp createdAt;
    private int quantityTicket;
    private double totalCost;
    private double discount;
    
    
    public Bill(int theaterId, int movieId, int quantityTicket, double totalCost, double discount) {
        this.theaterId = theaterId;
        this.movieId = movieId;
        this.quantityTicket = quantityTicket;
        this.totalCost = totalCost;
        this.discount = discount;
    }
    
    public Bill(int id, int theaterId, int movieId, Timestamp createdAt, int quantityTicket, double totalCost, double discount) {
        this.id = id;
        this.theaterId = theaterId;
        this.movieId = movieId;
        this.createdAt = createdAt;
        this.quantityTicket = quantityTicket;
        this.totalCost = totalCost;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    
    
    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public int getQuantityTicket() {
        return quantityTicket;
    }

    public void setQuantityTicket(int quantityTicket) {
        this.quantityTicket = quantityTicket;
    }
    

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    
}

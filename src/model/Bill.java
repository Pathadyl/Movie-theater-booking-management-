package model;

import java.sql.Date;


public class Bill {
    private int id;
    private int theaterId;
    private Date createdAt;
    private double totalCost;

    public Bill(int id, int theaterId, Date createdAt, double totalCost) {
        this.id = id;
        this.theaterId = theaterId;
        this.createdAt = createdAt;
        this.totalCost = totalCost;
    }
}

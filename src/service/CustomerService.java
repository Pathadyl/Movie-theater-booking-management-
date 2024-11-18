package service;

import model.Customer;
import model.Movie;
import model.Theater;

public abstract class CustomerService extends UserService {
    
    public CustomerService(Customer customer) {
        super(customer);
    }
    
    abstract public void bookingMovie(String name, String phone, String email, Movie movie, Theater theaterint, int quantity);
}

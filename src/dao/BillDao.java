package dao;

import model.Bill;
import model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDao {

// ==================================== Get Bill List Given Condition ==================================================
    public List<Bill> getMemberBillList(int memberId) {
        List<Bill> bills = new ArrayList<>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT b.* FROM bill b " +
                "JOIN member_bill mb ON b.id = mb.bill_id " +
                "JOIN member m ON mb.member_id = m.id " +
                "WHERE m.id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, memberId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bills.add(mapResultSetToBill(rs));
            }

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForGetBillRequest(actualSql, bills, "Get movie list by theater");

        } catch (SQLException e) {
            e.printStackTrace();

        }  finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return bills;
    }

    public List<Bill> getGuestBillList(int guestId) {
        List<Bill> bills = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT b.* FROM bill b " +
                    "JOIN guest_bill gb ON b.id = gb.bill_id " +
                    "JOIN guest g ON gb.guest_id = g.id " +
                    "WHERE g.id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, guestId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bills.add(mapResultSetToBill(rs));
            }

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForGetBillRequest(actualSql, bills, "Get bill list by guest");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return bills;
    }
    
    public void addMemberBill(int memberId, Bill bill) {
        Connection connection = JDBCConnection.getJDBCConnection();

        try {
            connection.setAutoCommit(false);

            String insertBillSql = "INSERT INTO bill (theater_id, movie_id, quantity_ticket, total_cost, discount) " +
                                    "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertBillStmt = connection.prepareStatement(insertBillSql, Statement.RETURN_GENERATED_KEYS)) {
                insertBillStmt.setInt(1, bill.getTheaterId());
                insertBillStmt.setInt(2, bill.getMovieId()); // Set the movie_id
                insertBillStmt.setInt(3, bill.getQuantityTicket());
                insertBillStmt.setDouble(4, bill.getTotalCost());
                insertBillStmt.setDouble(5, bill.getDiscount());

                int affectedRows = insertBillStmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating bill failed, no rows affected.");
                }

                try (ResultSet generatedKeys = insertBillStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int billId = generatedKeys.getInt(1);

                        String insertMemberBillSql = "INSERT INTO member_bill (member_id, bill_id) VALUES (?, ?)";
                        try (PreparedStatement insertMemberBillStmt = connection.prepareStatement(insertMemberBillSql)) {
                            insertMemberBillStmt.setInt(1, memberId);
                            insertMemberBillStmt.setInt(2, billId);
                            insertMemberBillStmt.executeUpdate();
                        }
                    } else {
                        throw new SQLException("Creating bill failed, no ID obtained.");
                    }
                }
            }

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void addGuestBill(String name, String phone, String email, Bill bill) {
        Connection connection = JDBCConnection.getJDBCConnection();

        try {
            connection.setAutoCommit(false);

            // Insert the guest into the database if they don't already exist
            String insertGuestSql = "INSERT INTO guest (name, phone, email) VALUES (?, ?, ?)";
            int guestId;
            try (PreparedStatement insertGuestStmt = connection.prepareStatement(insertGuestSql, Statement.RETURN_GENERATED_KEYS)) {
                insertGuestStmt.setString(1, name);
                insertGuestStmt.setString(2, phone);
                insertGuestStmt.setString(3, email);

                int affectedRows = insertGuestStmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating guest failed, no rows affected.");
                }

                try (ResultSet generatedKeys = insertGuestStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        guestId = generatedKeys.getInt(1);
                    } else {
                        throw new SQLException("Creating guest failed, no ID obtained.");
                    }
                }
            }

            // Insert the bill into the database
            String insertBillSql = "INSERT INTO bill (theater_id, movie_id, quantity_ticket, total_cost, discount) " +
                                   "VALUES (?, ?, ?, ?, ?)";
            int billId;
            try (PreparedStatement insertBillStmt = connection.prepareStatement(insertBillSql, Statement.RETURN_GENERATED_KEYS)) {
                insertBillStmt.setInt(1, bill.getTheaterId());
                insertBillStmt.setInt(2, bill.getMovieId()); // Set the movie_id
                insertBillStmt.setInt(3, bill.getQuantityTicket());
                insertBillStmt.setDouble(4, bill.getTotalCost());
                insertBillStmt.setDouble(5, bill.getDiscount());

                int affectedRows = insertBillStmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating bill failed, no rows affected.");
                }

                try (ResultSet generatedKeys = insertBillStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        billId = generatedKeys.getInt(1);
                    } else {
                        throw new SQLException("Creating bill failed, no ID obtained.");
                    }
                }
            }

        // Insert the guest_bill relationship
        String insertGuestBillSql = "INSERT INTO guest_bill (guest_id, bill_id) VALUES (?, ?)";
        try (PreparedStatement insertGuestBillStmt = connection.prepareStatement(insertGuestBillSql)) {
            insertGuestBillStmt.setInt(1, guestId);
            insertGuestBillStmt.setInt(2, billId);
            insertGuestBillStmt.executeUpdate();
        }

        connection.commit();
    } catch (SQLException e) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        e.printStackTrace();
    } finally {
        if (connection != null) {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


    
    
// ===================================================================================================================
    private Bill mapResultSetToBill(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int theaterId = rs.getInt("theater_id");
        int movieId = rs.getInt("movie_id");
        Timestamp createdAt = rs.getTimestamp("created_at");
        int quantityTicket = rs.getInt("quantity_ticket");
        double totalCost = rs.getDouble("total_cost");
        double discount = rs.getDouble("discount");

        return new Bill(id, theaterId, movieId, createdAt, quantityTicket, totalCost, discount);
    }

    private void logForGetBillRequest(String sql, List<Bill> bills, String typeRequest) {
        if(!bills.isEmpty()) {
            System.out.println("\n(+)  " + typeRequest + " success!");
            System.out.println("(+)  Number of rows return: " + bills.size());
            System.out.println("(+)  Query:\n" + sql);
        } else {
            System.out.println("\n(+)  Number of rows return: " + 0);
        }
    }
}

package dao;

import model.Showtime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Theater;

public class ShowtimeDao {
    
    public List<Showtime> getShowTimeListByMovie(int movieId) {
        List<Showtime> showtimes = new ArrayList<>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT s.id, m.id AS movie_id, t.id AS theater_id, s.show_time, s.seats, s.available " +
                "FROM movie m " +
                "JOIN movie_theater mt ON m.id = mt.movie_id " +
                "JOIN theater t ON t.id = mt.theater_id " +
                "JOIN showtime s ON mt.id = s.movie_theater_id " +
                "WHERE m.id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
                                                                               ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                                               ResultSet.CONCUR_READ_ONLY)) {
            preparedStatement.setInt(1, movieId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int movie_id = rs.getInt("movie_id");
                int theater_id = rs.getInt("theater_id");
                Timestamp ts = rs.getTimestamp("show_time");
                int seats = rs.getInt("seats");
                int available = rs.getInt("available");
                
                Showtime showtime = new Showtime(id, movie_id, theater_id, ts, seats, available);
                showtimes.add(showtime);
            }

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForShowTimeQuery(actualSql, rs, "Get show time list by Movie");

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

        return showtimes;
    }
    
    public List<Theater> getTheaterListByMovie(int movieId) {
        List<Theater> theaters = new ArrayList<>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT t.id, t.name, t.location, t.avatar_path, t.cover_path, t.visibility " +
                     "FROM theater t " +
                     "JOIN movie_theater mt ON t.id = mt.theater_id " +
                     "JOIN movie m ON m.id = mt.movie_id " +
                     "WHERE m.id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, movieId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String location = rs.getString("location");
                String avatarPath = rs.getString("avatar_path");
                String coverPath = rs.getString("cover_path");
                boolean visibility = rs.getBoolean("visibility");

                Theater theater = new Theater(id, name, location, avatarPath, coverPath, visibility);
                theaters.add(theater);
            }

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

            return theaters;
    }
    
    public List<Showtime> getShowTimeListByMovieAndTheater(int movieId, int theaterId) {
        List<Showtime> showtimes = new ArrayList<>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT s.id, m.id AS movie_id, t.id AS theater_id, s.show_time, s.seats, s.available " +
                     "FROM movie m " +
                     "JOIN movie_theater mt ON m.id = mt.movie_id " +
                     "JOIN theater t ON t.id = mt.theater_id " +
                     "JOIN showtime s ON mt.id = s.movie_theater_id " +
                     "WHERE m.id = ? AND t.id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, movieId);
            preparedStatement.setInt(2, theaterId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int movie_id = rs.getInt("movie_id");
                int theater_id = rs.getInt("theater_id");
                Timestamp show_time = rs.getTimestamp("show_time");
                int seats = rs.getInt("seats");
                int available = rs.getInt("available");

                Showtime showtime = new Showtime(id, movie_id, theater_id, show_time, seats, available);
                showtimes.add(showtime);
            }

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

        return showtimes;
    }
    
    public List<Theater> getTheaterListByShowtimeDate(Timestamp show_time) {
        List<Theater> theaters = new ArrayList<>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT DISTINCT t.id, t.name, t.location, t.avatar_path, t.cover_path, t.visibility " +
                     "FROM theater t " +
                     "JOIN movie_theater mt ON t.id = mt.theater_id " +
                     "JOIN showtime s ON mt.id = s.movie_theater_id " +
                     "WHERE s.show_time = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setTimestamp(1, show_time);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String location = rs.getString("location");
                String avatarPath = rs.getString("avatar_path");
                String coverPath = rs.getString("cover_path");
                boolean visibility = rs.getBoolean("visibility");

                Theater theater = new Theater(id, name, location, avatarPath, coverPath, visibility);
                theaters.add(theater);
            }

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

        return theaters;
    }
    
    public List<Theater> getTheaterListByMovieIdAndShowtimeDate(int movieId, Timestamp showTime) {
        List<Theater> theaters = new ArrayList<>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT DISTINCT t.id, t.name, t.location, t.avatar_path, t.cover_path, t.visibility " +
                     "FROM theater t " +
                     "JOIN movie_theater mt ON t.id = mt.theater_id " +
                     "JOIN showtime s ON mt.id = s.movie_theater_id " +
                     "WHERE mt.movie_id = ? AND s.show_time = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, movieId);
            preparedStatement.setTimestamp(2, showTime);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String location = rs.getString("location");
                String avatarPath = rs.getString("avatar_path");
                String coverPath = rs.getString("cover_path");
                boolean visibility = rs.getBoolean("visibility");

                Theater theater = new Theater(id, name, location, avatarPath, coverPath, visibility);
                theaters.add(theater);
            }

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

        return theaters;
    }
    
    
    private void logForShowTimeQuery(String sql, ResultSet rs, String typeRequest) throws SQLException {
        int rowResult = 0;

        if(rs == null)
            System.out.println("\n(+)  Number of rows returned: " + rowResult);

        rs.last();
        rowResult = rs.getRow();
        System.out.println("\n(+)  " + typeRequest + " success!");
        System.out.println("(+)  Number of rows returned: " + rowResult);
        System.out.println("(+)  Query:\n" + sql);
    }
    
    public boolean updateAvailableSeats(int showtimeId, int newAvailableSeats) {
        Connection connection = JDBCConnection.getJDBCConnection();
        boolean updateSuccess = false;

        String sql = "UPDATE showtime SET available = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, newAvailableSeats);
            preparedStatement.setInt(2, showtimeId);

            int affectedRows = preparedStatement.executeUpdate();
            updateSuccess = (affectedRows > 0);

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForUpdateAvailableSeats(actualSql, newAvailableSeats, showtimeId);

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

        return updateSuccess;
    }

//    private Showtime mapResultSetToShowtime(ResultSet rs) throws SQLException {
//        int id = rs.getInt("id");
//        int id = rs.getInt("")
//        Date showDate = rs.getDate("show_date");
//        int seats = rs.getInt("seats");
//        int available = rs.getInt("available");
//
//        return new Showtime(id, showDate, startTime, endTime, seats, available);
//    }
    
    private void logForUpdateAvailableSeats(String sql, int newAvailableSeats, int showtimeId) {
    // Implement your logging logic here
    System.out.println("SQL: " + sql + " | New Available Seats: " + newAvailableSeats + " | Showtime ID: " + showtimeId);
}

}

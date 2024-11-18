package dao;

import model.Role;
import model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {
    
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM movie";
        
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
                                                                               ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                                               ResultSet.CONCUR_READ_ONLY)) {
           
            
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                movies.add(mapResultSetToMovie(rs));
            }

            logForMovieQuery(sql, rs, "Get all movies");

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

        return movies;
    }
    
    
// ==================================== Get Movie List Given Condition ===============================================
    public Movie getMovieById(int movieId) {
        Connection connection = JDBCConnection.getJDBCConnection();

        Movie movie = null;

        String sql = "SELECT * FROM movie " +
                     "WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
                                                                               ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                                               ResultSet.CONCUR_READ_ONLY)) {
            preparedStatement.setInt(1, movieId);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    movie = mapResultSetToMovie(rs);
                }

                String actualSql = preparedStatement.toString().split(": ")[1];
                logForMovieQuery(actualSql, rs, "GetAuthenticated admin in DB");
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

        return movie;
    }

    public List<Movie> getMoviesByAvailability(Role role, boolean available) {
        List<Movie> movies = new ArrayList<>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM movie WHERE availability = ?";
        if (role != Role.ADMIN)
            sql += " AND visibility = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
                                                                               ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                                               ResultSet.CONCUR_READ_ONLY)) {
            preparedStatement.setBoolean(1, available);
            if (role != Role.ADMIN)
                preparedStatement.setBoolean(2, true);
            
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                movies.add(mapResultSetToMovie(rs));
            }
            
            String actualSql = preparedStatement.toString().split(": ")[1];
            logForMovieQuery(actualSql, rs, "Get all movies");

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

        return movies;
    }

    public List<Movie> searchMovieByTitle(String t, Role role) {
        List<Movie> movies = new ArrayList<>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM movie" +
                     " WHERE LOWER(title) LIKE LOWER(?)";
        if(role != Role.ADMIN)
            sql += " AND visibility = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
                                                                               ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                                               ResultSet.CONCUR_READ_ONLY)) {
            preparedStatement.setString(1, "%" + t + "%");
            if(role != Role.ADMIN)
                preparedStatement.setBoolean(2, true);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                movies.add(mapResultSetToMovie(rs));
            }

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForMovieQuery(actualSql, rs, "Get movie by title");

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

        return movies;
    }

    public List<Movie> getMovieListByGenre(String g, boolean available, Role role) {
        List<Movie> movies = new ArrayList<>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM movie" +
                     " WHERE genre = ?" +
                     " AND availability = ?";

        if (role != Role.ADMIN)
            sql += " AND visibility = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
                                                                               ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                                               ResultSet.CONCUR_READ_ONLY)) {
            preparedStatement.setString(1, g);
            preparedStatement.setBoolean(2, available);
            if (role != Role.ADMIN)
                preparedStatement.setBoolean(3, true);

            String actualSql = preparedStatement.toString().split(": ")[1];
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                movies.add(mapResultSetToMovie(rs));
            }

            logForMovieQuery(actualSql, rs, "Get movie by genre");

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return movies;
    }

    public List<Movie> getMovieListByTheater(int theaterId, Role role) {
        List<Movie> movies = new ArrayList<>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT m.* FROM movie m " +
                "JOIN movie_theater mt ON m.id = mt.movie_id " +
                "JOIN theater t ON mt.theater_id = t.id " +
                "WHERE t.id = ?";
        if(role != Role.ADMIN)
            sql += "AND m.visibility = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
                                                                               ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                                               ResultSet.CONCUR_READ_ONLY)) {
            preparedStatement.setInt(1, theaterId);
            if (role != Role.ADMIN)
                preparedStatement.setBoolean(2, true);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                movies.add(mapResultSetToMovie(rs));
            }

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForMovieQuery(actualSql, rs, "Get movie list by theater");

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

        return movies;
    }


// ==================================== Modify Movie In Database ======================================================
    public boolean addMovieToDB(String title, String description, // Add movie function
                             String director, String genre, String duration,
                             double price, String posterPath, String coverPath,
                             boolean visibility, boolean availability) {
        boolean flag = false;

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "INSERT INTO movie (title, description, director, genre, duration, price, poster_path, cover_path, visibility, availability)" +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, director);
            preparedStatement.setString(4, genre);
            preparedStatement.setString(5, duration);
            preparedStatement.setDouble(6, price);
            preparedStatement.setString(7, posterPath);
            preparedStatement.setString(8, coverPath);
            preparedStatement.setBoolean(9, visibility);
            preparedStatement.setBoolean(10, availability);

            int rs = preparedStatement.executeUpdate();

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForMovieQuery(actualSql, rs, "Add movie to database");

            if (rs > 0)
                flag = true;

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

        return flag;
    }

    public boolean deleteMovieFromDB(int id) {           // Delete movie by ID function
        boolean flag = false;

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "DELETE FROM movie WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            int rs = preparedStatement.executeUpdate();

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForMovieQuery(actualSql, rs, "Delete movie from database");

            if (rs > 0)
                flag = true;

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

        return flag;
    }

    public boolean hideMovie(int id) {           // Set visibility of movie to 0 by ID
        boolean flag = false;

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "UPDATE movie SET visibility = 0 WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            int rs = preparedStatement.executeUpdate();

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForMovieQuery(actualSql, rs, "Hide movie from customer");

            if (rs > 0) flag = true;

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

        return flag;
    }

    public boolean editMovieFromDB(int id, String title, String description,                   // Edit movie function, when getting the data from UI,
                                String director, String genre, String duration,             // pass the value into this function
                                double price, String posterPath, String coverPath,                   // I have removed poster_path for testing
                                boolean visibility, boolean availability) {
        Connection connection =JDBCConnection.getJDBCConnection();
        boolean flag = false;
        String sql = "UPDATE movie " +
                     "SET title = ?, description = ?, director = ?, genre = ?, duration = ?, price = ?,poster_path = ?, cover_path = ?, visibility = ?, availability = ? " +
                     "WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, director);
            preparedStatement.setString(4, genre);
            preparedStatement.setString(5, duration);
            preparedStatement.setDouble(6, price);
            preparedStatement.setString(7, posterPath);
            preparedStatement.setString(8, coverPath);
            preparedStatement.setBoolean(9, visibility);
            preparedStatement.setBoolean(10, availability);
            preparedStatement.setInt(11, id);

            int rs = preparedStatement.executeUpdate();

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForMovieQuery(actualSql, rs, "Edit movie from database");
            if (rs > 0) flag = true;
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
        return flag;
    }
// ==================================== Modify Movie In Theater ======================================================
    public void addMovieToTheater(int theaterId, int movieId) {
        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "INSERT INTO movie_theater (movie_id, theater_id)" +
                     "VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, movieId);
            preparedStatement.setInt(2, theaterId);

            int rs = preparedStatement.executeUpdate();

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForMovieQuery(sql, rs, "Add movie to theater");

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void removeMovieFromTheater(int theaterId, int movieId) {
        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "DELETE FROM movie_theater " +
                "WHERE movie_id = ? AND theater_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, movieId);
            preparedStatement.setInt(2, theaterId);

            int rs = preparedStatement.executeUpdate();

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForMovieQuery(actualSql, rs, "Delete movie from theater");

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

// ====================================================================================================================
    private Movie mapResultSetToMovie(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String title = rs.getString("title");
        String description = rs.getString("description");
        String director = rs.getString("director");
        String genre = rs.getString("genre");
        String duration = rs.getString("duration");
        double price = rs.getDouble("price");
        String posterPath = rs.getString("poster_path");
        String coverPath = rs.getString("cover_path");
        boolean visibility = rs.getBoolean("visibility");
        boolean availability = rs.getBoolean("availability");

        return new Movie(id, title, description, director, genre, duration, price, posterPath, coverPath, visibility, availability);
    }

    private void logForMovieQuery(String sql, ResultSet rs, String typeRequest) throws SQLException {
        int rowResult = 0;

        if(rs == null)
            System.out.println("\n(+)  Number of rows returned: " + rowResult);

        rs.last();
        rowResult = rs.getRow();
        System.out.println("\n(+)  " + typeRequest + " success!");
        System.out.println("(+)  Number of rows returned: " + rowResult);
        System.out.println("(+)  Query:\n" + sql);

    }

    private void logForMovieQuery(String sql, int rs, String typeRequest) {
        if(rs <= 0)
            System.out.println("\n(+) Fail to " + typeRequest + "!");

        System.out.println("\n(+)  " + typeRequest + " success!");
        System.out.println("(+)  Number of rows affected: " + rs);
        System.out.println("(+)  Query:\n" + sql);

    }
}

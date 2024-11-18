package dao;

import model.Role;
import model.Theater;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheaterDao {
    public List<Theater> getAllTheaters(Role role) {
        List<Theater> theaters = new ArrayList<>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM theater";
        if (role != Role.ADMIN)
            sql += " WHERE visibility = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
                                                                               ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                                               ResultSet.CONCUR_READ_ONLY)){
                
             if (role != Role.ADMIN)
                preparedStatement.setBoolean(1, true);
             
             ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                theaters.add(mapResultSetToTheater(rs));
            }

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForTheaterQuery(actualSql, rs, "Get all theaters");

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

//    public List<Theater> searchTheaterByName(String n, Role role) {
//        List<Theater> theaters = new ArrayList<>();
//
//        Connection connection = JDBCConnection.getJDBCConnection();
//
//        String sql = "SELECT * FROM theater" +
//                " WHERE LOWER(name) LIKE LOWER(?)";
//        if(role != Role.ADMIN)
//            sql += " AND visibility = ?";
//
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
//                                                                               ResultSet.TYPE_SCROLL_INSENSITIVE,
//                                                                               ResultSet.CONCUR_READ_ONLY)) {
//            preparedStatement.setString(1, "%" + n + "%");
//            if(role != Role.ADMIN)
//                preparedStatement.setBoolean(2, true);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while(rs.next()) {
//                theaters.add(mapResultSetToTheater(rs));
//            }
//
//            String actualSql = preparedStatement.toString().split(": ")[1];
//            logForTheaterQuery(actualSql, rs, "Get theaters by name");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        return theaters;
//    }
    
    public Theater getTheaterByID(int id){
        Connection connection = JDBCConnection.getJDBCConnection();
        Theater t = null;
        String sql = "SELECT * FROM theater " +
                "WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY)) {
            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    t = mapResultSetToTheater(rs);
                }

                String actualSql = preparedStatement.toString().split(": ")[1];
                logForTheaterQuery(actualSql, rs, "Get Theater by id in DB");
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
        return t;
    }

    public boolean addTheaterToDB(String name, String location, boolean visibility, String avatar_path, String image_path){
        boolean flag = false;
        Connection connection =JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO theater(name, location, visibility, avatar_path, image_path) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, location);
            preparedStatement.setBoolean(3, visibility);
            preparedStatement.setString(4, avatar_path);
            preparedStatement.setString(5, image_path);
            int rs = preparedStatement.executeUpdate();

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForTheaterQuery(actualSql, rs, "Add theater to DB");
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

    public boolean removeTheaterFromDB(int id){
        Connection connection =JDBCConnection.getJDBCConnection();
        boolean flag = false;
        String sql = "DELETE FROM theater WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int rs = preparedStatement.executeUpdate();

            String actualSql = preparedStatement.toString().split(": ")[1];
            logForTheaterQuery(actualSql,  rs,"Remove theater from DB");
            if (rs > 0){
                flag = true;
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
        return flag;

    }

    public boolean editTheaterFromDB(int id, String name, String location, boolean visibility, String avatar_path, String image_path){
        Connection connection =JDBCConnection.getJDBCConnection();
        boolean flag = false;
        String sql = "UPDATE theater SET name = ?, location = ?, visibility = ?, avatar_path = ?, image_path = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, location);
            preparedStatement.setBoolean(3,visibility);
            preparedStatement.setString(4, avatar_path);
            preparedStatement.setString(5, image_path);
            preparedStatement.setInt(6, id);

            int rs = preparedStatement.executeUpdate();
            if (rs > 0){
                flag = true;
            }
            String actualSql = preparedStatement.toString().split(": ")[1];
            logForTheaterQuery(actualSql, rs, "Edit theater from DB");

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

    
    
    
    private Theater mapResultSetToTheater(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String location = rs.getString("location");
        String avatarPath = rs.getString("avatar_path");
        String coverPath = rs.getString("cover_path");
        boolean visibility = rs.getBoolean("visibility");

        return new Theater(id, name, location, avatarPath, coverPath, visibility);
    }

    private void logForTheaterQuery(String sql, ResultSet rs, String typeRequest) throws SQLException {
        int rowResult = 0;
        if(rs == null)
            System.out.println("\n(+)  Number of rows return: " + rowResult);

        rs.last();
        rowResult = rs.getRow();
        System.out.println("\n(+)  " + typeRequest + " success!");
        System.out.println("(+)  Number of rows return: " + rowResult);
        System.out.println("(+)  Query:\n" + sql);
    }

    private void logForTheaterQuery(String sql,  int rs, String typeRequest) {
        if(rs <= 0)
            System.out.println("\n(+) Fail to " + typeRequest + "!");

        System.out.println("\n(+)  " + typeRequest + " success!");
        System.out.println("(+)  Number of rows affected: " + rs);
        System.out.println("(+)  Query:\n" + sql);
    }

}

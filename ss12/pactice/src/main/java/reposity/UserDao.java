package reposity;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "Hoilamchi102";

    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    public UserDao() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

//    public static void main(String[] args) throws SQLException {
//        UserDao userDao = new UserDao();
//        if (userDao.getConnection() != null) {
//            System.out.println("kết nối thành công ");
//        } else {
//            System.out.println("kết nối không thành công ");
//        }
//       List<User>  user = userDao.selectAllUsers();
//        for (User temp  : user) {
//            System.out.println(temp);
//        }
//        User user1 = new User("tran","tran","tran");
//        userDao.insertUser(user1);
////        System.out.println(user);
//        List<User>  user2 = userDao.selectAllUsers();
//        for (User temp  : user2) {
//            System.out.println(temp);
//        }
//    }


    @Override
    public void insertUser(User user) throws SQLException {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            /////
        }

    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> list = new ArrayList<>();
        String query = "select*from users";
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email")
                        , rs.getString("country"));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        String query = "delete from users where id = ?;";
        Connection connection = getConnection();
        PreparedStatement sttm = connection.prepareStatement(query);
        sttm.setString(1, String.valueOf(id));
        sttm.executeUpdate();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String query = " update users set name = ? , email = ?,country= ? where id = ?; ";
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getCountry());
        ps.setString(4, String.valueOf(user.getId()));
        ps.executeUpdate();
    }

    public List<User> findCountry(String country) {
        String query = "select*from users where country like ?;";
        List<User> list = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+ country+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name")
                        , rs.getString("email"), rs.getString("country"));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public List<User> sortUserByName(){
        List<User> users = new ArrayList<>();
        String query = "select*from users order by name desc;";
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                User user = new User(rs.getInt("id"),
                                     rs.getString("name"),
                                     rs.getString("email"),
                                     rs.getString("country")   );
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();

       List<User> users= userDao.sortUserByName();
        for (User tem :
                users)
        {
            System.out.println(tem);
        }
    }

}

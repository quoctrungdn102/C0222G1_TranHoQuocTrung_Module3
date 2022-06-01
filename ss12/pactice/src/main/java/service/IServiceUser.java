package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IServiceUser {
    public void insertUser(User user) throws SQLException;
    public List<User> selectAllUsers();
    public User selectUser(int id);
    public void updateUser(User user) throws SQLException;
    public void deleteUser(int id) throws SQLException;
    public List<User> findCountry(String country);
    public List<User> sortUserByName();
}

package service;

import model.User;
import reposity.IUserDao;
import reposity.UserDao;

import java.sql.SQLException;
import java.util.List;

public class ServiceUser implements IServiceUser {
    IUserDao iUserDao = new UserDao();
    @Override
    public void insertUser(User user) throws SQLException {
        iUserDao.insertUser(user);
    }

    @Override
    public List<User> selectAllUsers() {
        return iUserDao.selectAllUsers();
    }

    @Override
    public User selectUser(int id) {
        return iUserDao.selectUser(id);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        iUserDao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        iUserDao.deleteUser(id);
    }
    public List<User> findCountry(String country){
        return iUserDao.findCountry(country);
    }

    @Override
    public List<User> sortUserByName() {
        return iUserDao.sortUserByName();
    }


}

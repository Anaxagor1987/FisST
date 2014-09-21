package ua.lviv.fis.dao;

import ua.lviv.fis.domain.User;

import java.sql.SQLException;
import java.util.List;


public interface UserDao {
public void addUser(User user) throws SQLException;
public void deleteUser(User user) throws SQLException;
public User getUser(int id) throws SQLException;
public List<User> getAll() throws SQLException;
public void updateUser(User user) throws SQLException;
}

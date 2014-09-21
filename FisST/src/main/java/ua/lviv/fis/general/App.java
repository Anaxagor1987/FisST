package ua.lviv.fis.general;

import java.sql.SQLException;

import ua.lviv.fis.dao.UserDao;
import ua.lviv.fis.domain.User;


public class App 
{
    public static void main( String[] args ) throws SQLException {
    	Factory factory =Factory.instance;
    	UserDao userDao = factory.getUserDao();
    	
    	userDao.addUser(new User("Yuriy", "Anax@gmail.com"));
    	userDao.addUser(new User("Anax", "blabla@gmail.com"));
    }
}

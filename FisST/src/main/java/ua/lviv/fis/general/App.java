package ua.lviv.fis.general;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.fis.dao.UserDao;
import ua.lviv.fis.domain.User;


public class App 
{
    public static void main( String[] args ) throws SQLException {
    	Factory factory =Factory.instance;
    	UserDao userDao = factory.getUserDao();
    	
    	userDao.addUser(new User("Yuriy", "Anax@gmail.com"));
    	userDao.addUser(new User("Anax", "blabla@gmail.com"));
        userDao.addUser(new User("Vitman", "vit@ukr.net"));
    	
    	List<User> users = userDao.getAll();
    	
    	for (User u : users) {
			System.out.println(u);
		}
    }
}

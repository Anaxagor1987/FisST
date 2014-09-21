package ua.lviv.fis.general;

import ua.lviv.fis.dao.UserDao;
import ua.lviv.fis.dao.impl.UserDaoImpl;

public class Factory {
	public static Factory instance = new Factory();
	public UserDao userDao;
	
	private Factory(){
	}
	public static Factory getFactoryInstance(){
		return Factory.instance;
	}
	public UserDao getUserDao(){
		if(userDao == null) 
			userDao = new UserDaoImpl();
		return userDao;
	}
}

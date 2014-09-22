package ua.lviv.fis.general;

import ua.lviv.fis.dao.ProductDao;
import ua.lviv.fis.dao.UserDao;
import ua.lviv.fis.dao.impl.ProductDaoImpl;
import ua.lviv.fis.dao.impl.UserDaoImpl;

public class Factory {
	public static Factory instance = new Factory();
	private UserDao userDao;
	private ProductDao productDao;
	
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
	
	public ProductDao getProductDao(){
		if(productDao==null)
			productDao=new ProductDaoImpl();
		return productDao;
	}
}

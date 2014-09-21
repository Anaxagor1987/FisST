package ua.lviv.fis.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import ua.lviv.fis.dao.UserDao;
import ua.lviv.fis.domain.User;
import ua.lviv.fis.util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public void addUser(User user) throws SQLException {
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null && session.isOpen())
				session.close();
		}
	}

	@Override
	public void deleteUser(User user) throws SQLException {
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null && session.isOpen())
				session.close();
		}
	}

	@Override
	public User getUser(int id) throws SQLException {
		User searchedUser = null;
		Session session=null;
		
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			searchedUser = (User)session.get(User.class, id);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null && session.isOpen())
				session.close();
		}
		return searchedUser;
	}

	@Override
	public List<User> getAll() throws SQLException {
		List<User>users = null;
		
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			users = session.createCriteria(User.class).list();
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null && session.isOpen())
				session.close();
		}
		return users;
	}

	@Override
	public void updateUser(User user) throws SQLException {
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null && session.isOpen())
				session.close();
		}
		
	}

}

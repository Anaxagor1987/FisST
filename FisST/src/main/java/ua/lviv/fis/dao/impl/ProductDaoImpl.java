package ua.lviv.fis.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import ua.lviv.fis.dao.ProductDao;
import ua.lviv.fis.domain.Product;
import ua.lviv.fis.util.HibernateUtil;

public class ProductDaoImpl implements ProductDao{

	@Override
	public void addProduct(Product product) throws SQLException {
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null && session.isOpen())
				session.close();
		}
	}

	@Override
	public void deleteProduct(Product product) throws SQLException {
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null && session.isOpen())
				session.close();
		}
	}

	@Override
	public Product getProduct(int id) throws SQLException {
		Product searchedProduct = null;
		Session session=null;
		
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			searchedProduct = (Product)session.get(Product.class, id);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null && session.isOpen())
				session.close();
		}
		return searchedProduct;
	}

	@Override
	public List<Product> getAll() throws SQLException {
		List<Product>products = null;
		
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			products = session.createCriteria(Product.class).list();
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null && session.isOpen())
				session.close();
		}
		return products;
	}

	@Override
	public void updateProduct(Product product) throws SQLException {
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null && session.isOpen())
				session.close();
		}
		
	}
}

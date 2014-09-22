package ua.lviv.fis.dao;

import java.sql.SQLException;
import java.util.List;



import ua.lviv.fis.domain.Product;

public interface ProductDao {
	public void addProduct(Product product) throws SQLException;
	public void deleteProduct(Product product) throws SQLException;
	public Product getProduct(int id) throws SQLException;
	public List<Product> getAll() throws SQLException;
	public void updateProduct(Product product) throws SQLException;
}

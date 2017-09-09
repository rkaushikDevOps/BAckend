package ecom.test.BackEnd.dao;

import java.util.List;

import ecom.test.BackEnd.dto.Product;

public interface ProductDao {
	public Product getProduct(Long id);

	public List<Product> productList();

	boolean add(Product product);

	boolean update(Product product);

	boolean delete(Long id);
}

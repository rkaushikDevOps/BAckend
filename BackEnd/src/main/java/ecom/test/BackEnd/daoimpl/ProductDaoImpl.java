package ecom.test.BackEnd.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ecom.test.BackEnd.dao.ProductDao;
import ecom.test.BackEnd.dto.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired(required = true)
	private SessionFactory sessionFactory;  
	@Override
	public Product getProduct(Long id) {
		String selectProduct = "From Product where prod_id=:parameter";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(selectProduct, Product.class);
		query.setParameter("parameter", id);
		try{
		return query.getSingleResult();	
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	public List<Product> productList() {
		String getProduct = "From Product";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(getProduct,Product.class);
		try{
			return query.getResultList();
		}
		catch(Exception  e)
		{
		return null;
		}
	}

	@Override
	public boolean add(Product product) {
		try{
			//Add Cart Item To Database
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex);	
		return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try{
			//Add Cart Item To Database
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex);	
		return false;
		}	
	}

	@Override
	public boolean delete(Long id) {
		Product product = getProduct(id);
		product.setActiveIs(false);
		try{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex);	
		return false;
		}
	}

}

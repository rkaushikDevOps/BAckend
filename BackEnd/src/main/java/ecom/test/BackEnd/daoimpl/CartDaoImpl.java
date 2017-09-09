package ecom.test.BackEnd.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ecom.test.BackEnd.dao.CartDao;
import ecom.test.BackEnd.dto.Cart;

@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao{
	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	public boolean updateCart(Cart cart) {
		try{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;	
			}
	}

	@Override
	public Cart getCartBycart_Id(Long cart_Id) {
		String selectCart = "From Cart where cart_Id=:parameter";
		Query<Cart> query = sessionFactory.getCurrentSession().createQuery(selectCart, Cart.class);
		query.setParameter("parameter", cart_Id);
		try{
			return query.getSingleResult();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	public boolean deleteAllCartItems(Cart cart) {
		String deleteCart = "Delete from CartItem where cart=:parameter";
		Query<Cart> query  = sessionFactory.getCurrentSession().createQuery(deleteCart, Cart.class);
		query.setParameter("parameter", cart);
		try{
		System.out.println(query.executeUpdate());
		return true;
	} catch (Exception ex) {
		ex.printStackTrace();
		System.out.println(ex);
		return false;
	}
	}
}

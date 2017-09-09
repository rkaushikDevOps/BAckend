package ecom.test.BackEnd.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ecom.test.BackEnd.dao.CartItemDao;
import ecom.test.BackEnd.dto.Cart;
import ecom.test.BackEnd.dto.CartItem;
import ecom.test.BackEnd.dto.Product;

@Repository("cartItemDao")
@Transactional
public class CartItemDaoImpl implements CartItemDao{

	@Autowired(required = true)
	private SessionFactory sessionFactory;
	@Override
	public boolean searchCartItemByUserIdAndProductId(Cart cart, Product product) {
		String searchCartItem = "From CartItem where cart=:parameter1 and product=:parameter2";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(searchCartItem, CartItem.class);
		query.setParameter("parameter1", cart);
		query.setParameter("parameter2", product);
		try{
			query.getSingleResult();
			return true;
		}
		catch(Exception e){
		return false;
		}
	}

	@Override
	public CartItem getCartItemByUserIdAndProductId(Cart cart, Product product) {
		String selectCartId = "FROM CartItem where cart=:parameter1 and product=:parameter2";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(selectCartId, CartItem.class);
		query.setParameter("parameter1", cart);
		query.setParameter("parameter2", product);
		try {
			return query.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public boolean addCartItem(CartItem cartItem) {
		try {
			// add cart item to the database
			sessionFactory.getCurrentSession().save(cartItem);
			// sessionFactory.getCurrentSession().evict(cartItem);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	@Override
	public List<CartItem> cartItemGetByCart(Cart cart) {
		String getAllCartItem = "From CartItem where cart=:parameter";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(getAllCartItem, CartItem.class);
		query.setParameter("parameter", cart);
		try{
			return query.getResultList();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		try {
			// update the User to the database
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	@Override
	public boolean deleteCartItem(Long cartItem_Id) {
		CartItem cartItem = getCartItemByCartItem_Id(cartItem_Id);
		try {
			// Delete the cartItem to the database
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public CartItem getCartItemByCartItem_Id(Long cartItem_Id) {
		String getCartItem = "From CartItem where cart=:parameter";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(getCartItem, CartItem.class);
		query.setParameter("parameter", cartItem_Id);
		try{
			return query.getSingleResult();
		}
		catch(Exception e)
		{
		return null;
		}
	}

}

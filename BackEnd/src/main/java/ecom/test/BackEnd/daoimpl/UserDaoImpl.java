package ecom.test.BackEnd.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ecom.test.BackEnd.dao.UserDao;
import ecom.test.BackEnd.dto.Cart;
import ecom.test.BackEnd.dto.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired(required = true)
	private SessionFactory sessionFactory;
	@Override
	public User getUserByUsername(String email) {
		//Select User Using User Email Id
		String selectUserId = "From User where uemail=:parameter";
		Query<User> query = sessionFactory.getCurrentSession().createQuery(selectUserId, User.class);
		query.setParameter("parameter",email);
		try{
			return query.getSingleResult();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	public boolean add(User user) {
		try{
			//Mapping Cart To User
		Cart cart = new Cart();
		cart.setUser(user);
		user.setCart(cart);
		sessionFactory.getCurrentSession().persist(user);
		return true;}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	@Override
	public boolean update(User user) {
		try{
			sessionFactory.getCurrentSession().update(user);
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
	public boolean delete(String email) {
		User user = getUserByUsername(email);
		user.setEnable(false);
		try{
			sessionFactory.getCurrentSession().update(user);
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
	public User getUserById(Long user_id) {
		String selectUserId = "From User where user_id=:parameter";
		Query<User> query = sessionFactory.getCurrentSession().createQuery(selectUserId, User.class);
		query.setParameter("parameter", user_id);
		try{
			return query.getSingleResult();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	
}

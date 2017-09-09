package ecom.test.BackEnd.dao;

import ecom.test.BackEnd.dto.Cart;

public interface CartDao {
	public boolean updateCart(Cart cart);

	public Cart getCartBycart_Id(Long cart_Id);

	public boolean deleteAllCartItems(Cart cart);
}

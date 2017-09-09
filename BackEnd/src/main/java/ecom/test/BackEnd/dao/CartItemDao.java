package ecom.test.BackEnd.dao;

import java.util.List;

import ecom.test.BackEnd.dto.Cart;
import ecom.test.BackEnd.dto.CartItem;
import ecom.test.BackEnd.dto.Product;

public interface CartItemDao {
	public boolean searchCartItemByUserIdAndProductId(Cart cart, Product product);

	public CartItem getCartItemByUserIdAndProductId(Cart cart, Product product);

	public boolean addCartItem(CartItem cartItem);

	public List<CartItem> cartItemGetByCart(Cart cart);

	public boolean updateCartItem(CartItem cartItem);

	public boolean deleteCartItem(Long cartItem_Id);

	public CartItem getCartItemByCartItem_Id(Long cartItem_Id);
}

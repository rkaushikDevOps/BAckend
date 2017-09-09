package ecom.test.BackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ecom.test.BackEnd.dao.CartDao;
import ecom.test.BackEnd.dao.CartItemDao;
import ecom.test.BackEnd.dao.ProductDao;
import ecom.test.BackEnd.dao.UserDao;
import ecom.test.BackEnd.dto.Cart;
import ecom.test.BackEnd.dto.CartItem;
import ecom.test.BackEnd.dto.Product;
import ecom.test.BackEnd.dto.User;

public class TestCase1 {
	private static AnnotationConfigApplicationContext context;
	
	static UserDao userDao;
	static ProductDao productDao;
	static CartDao cartDao;
	static CartItemDao cartItemDao;
	User user;
	Product product;
	Cart cart;
	CartItem cartitem;
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("ecom.test.BackEnd");
		context.refresh();

		userDao = (UserDao) context.getBean("userDao");
		productDao = (ProductDao) context.getBean("productDao");
		cartItemDao = (CartItemDao) context.getBean("cartItemDao");
		cartDao = (CartDao) context.getBean("cartDao");
	}

	/*@Test
	public void test1() {
		user = new User();
		user.setContact("9988556677");
		user.setUemail("admin@gmail.com");
		user.setEnable(true);
		user.setUname("admin");
		user.setPassword("admin");
		user.setRole("ADMIN");
		user.setAddress("Delhi");

		assertEquals(true, userDao.add(user));
	}*/
	/*@Test
	public void test2() {
		product = new Product();
		product.setProd_brand("OnePlus");
		product.setProd_name("OnePlus 5");
		product.setPrice(32999);
		product.setProd_description("6GB RAM 64GB ROM Black Color");
		product.setProdImg_url("imgurl");
		product.setQuantity(100);
		product.setSupplier("Amazon");
		assertEquals(true, productDao.add(product));
	}*/
	@Test
	public void test3() {
		//Test For Updating Cart And CartItem As per user
		user = userDao.getUserByUsername("admin@gmail.com");
		cartitem = new CartItem();
		cartitem.setCart(user.getCart());
		product = productDao.getProduct(new Long(1));
		long price = product.getPrice();
		cartitem.setSell_quantity(3);
		cartitem.setTotal_price(price * cartitem.getSell_quantity());
		cartitem.setProduct(product);
		cart = cartDao.getCartBycart_Id(new Long(4));
		cart.setCartItemCount(cartitem.getSell_quantity());
		cart.setGrandTotal(cartitem.getTotal_price());
		cartItemDao.addCartItem(cartitem);
		assertEquals(true, cartDao.updateCart(cart));
	}
}

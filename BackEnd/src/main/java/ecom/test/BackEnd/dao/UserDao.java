package ecom.test.BackEnd.dao;

import ecom.test.BackEnd.dto.User;

public interface UserDao {
	public User getUserByUsername(String email);

	boolean add(User user);

	boolean update(User user);

	boolean delete(String email);

	public User getUserById(Long user_id);
}

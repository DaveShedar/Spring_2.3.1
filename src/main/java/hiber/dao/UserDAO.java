package hiber.dao;

import hiber.entity.User;

import java.util.List;



public interface UserDAO {

	public List< User > getUsers();

	public void saveUser(User user);

	public User getUser(int theId);

	public void deleteUser(int theId);
	
}

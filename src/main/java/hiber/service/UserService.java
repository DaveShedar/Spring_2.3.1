package hiber.service;

import hiber.entity.User;

import java.util.List;



public interface UserService {

	public List< User > getUsers();

	public void saveUser(User user);

	public User getUser(int theId);

	public void deleteUser(int theId);
	
}

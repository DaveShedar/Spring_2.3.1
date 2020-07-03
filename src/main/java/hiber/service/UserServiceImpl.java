package hiber.service;

import java.util.List;

import hiber.dao.UserDAO;
import hiber.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public List< User > getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}

	@Override
	@Transactional
	public User getUser(int theId) {
		return userDAO.getUser(theId);
	}

	@Override
	@Transactional
	public void deleteUser(int theId) {
		userDAO.deleteUser(theId);
	}

}






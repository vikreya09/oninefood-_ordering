package onlinefood.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlinefood.dao.UserDao;
import onlinefood.exception.EmptyInputException;
import onlinefood.model.User;
@Service
public class UserService implements IUserService {
	@Autowired
    private UserDao dao;
	@Override
	public User login(String email, String password) {
		// TODO Auto-generated method stub
		return dao.findByEmailIdAndPassword(email, password);
	}

	@Override
	public User createLogin(@Valid User log) {
		if(log.getEmailId().isEmpty() || log.getEmailId().length()==0)
		{
			throw new EmptyInputException("601","Input Field can't be Empty");
		}
		return dao.save(log);
	}

	@Override
	public User updateLogin(User user) {
		// TODO Auto-generated method stub
		User use= dao.findByEmailId(user.getEmailId());
		use.setName(user.getName());
		use.setAddress(user.getAddress());
		use.setPhoneNumber(user.getPhoneNumber());
		use.setPassword(user.getPassword());
		return dao.save(use);
	}

	@Override
	public User deleteLogin(String email) {
		User user=dao.findByEmailId(email);
		if(user!=null)
		{
			dao.delete(user);
			return user;
		}
		else
		{
			throw new EmptyInputException("601","Input Field can't be Empty");
		}
		//return user;
	}

	@Override
	public User PrintUser(int id) {
		User user=dao.findById(id).get();
		return user;
	}

}

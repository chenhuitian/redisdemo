package rediscache.server;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import rediscache.entity.User;
import rediscache.repository.UserRepository;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public Map<String, Object> getUserInfo(String username) {
		return null;
	}

	@Override
	public Set<String> getRoles(String username) {
		// TODO Auto-generated method stub
		Set<String> roles = new HashSet<>();
		if ("admin".equals(username)) {
			roles.add("user");
	        roles.add("admin");
			
        } else if("guest".equals(username)) {
        	roles.add("user");
        }
		
        
        return roles;
	}

	@Override
	public Set<String> getPrivileges(String username) {
		// TODO Auto-generated method stub
		Set<String> privileges = new HashSet<>();
		
		if ("admin".equals(username)) {
			privileges.add("user:list");
			privileges.add("user:create");
			
        } else if("guest".equals(username)) {
        	privileges.add("user:list");
        }
		
        return privileges;
	}

	@Override
	@Cacheable(value = "user",key = "#id")
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}


	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public User addUser(User user) {
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findByUserNameAndPassWord(String userName, String passWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

package rediscache.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rediscache.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserNameAndPassWord(String userName, String passWord);

	Optional<User> findByUserName(String userName);

}

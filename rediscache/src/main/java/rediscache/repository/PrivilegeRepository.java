package rediscache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import rediscache.entity.Privilege;

@Service
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
	
}

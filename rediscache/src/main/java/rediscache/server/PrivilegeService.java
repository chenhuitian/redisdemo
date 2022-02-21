package rediscache.server;

import java.util.List;
import java.util.Optional;

import rediscache.entity.Privilege;

public interface PrivilegeService {
	List<Privilege> findAll();
	Optional<Privilege> findById(Long id);
	Privilege updatePrivilege(Privilege privilege);
	void deletePrivilege(Long privilegeId);
	Privilege addPrivilege(Privilege privilege);
	
}

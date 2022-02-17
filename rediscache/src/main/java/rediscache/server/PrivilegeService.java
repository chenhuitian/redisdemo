package rediscache.server;

import java.util.List;
import java.util.Optional;

import rediscache.entity.Privilege;

public interface PrivilegeService {
	Optional<Privilege> findfindById(Long id);
	List<Privilege> findAll();
	Privilege updatePrivilege(Privilege privilege);
	void deletePrivilege(Long privilegeId);
	Privilege addPrivilege(Privilege privilege);
}

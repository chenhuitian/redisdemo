package rediscache.server;

import java.util.List;
import java.util.Optional;

import rediscache.entity.Role;

public interface RoleService {
	 List<Role> findAll();
	 Optional<Role> findRoleById(long id);
	 Role addRole(Role role);
	 void deleteRole(Long id);
	 Role updateRole(Role role);
}

package rediscache.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import rediscache.entity.Privilege;
import rediscache.repository.PrivilegeRepository;
@Service
public class PrivilegeServiceImp implements PrivilegeService {

	@Autowired
	PrivilegeRepository PrivilegeRepository;
	
	@Override
	@Cacheable(value = "privilege",key = "#id")
	public Optional<Privilege> findfindById(Long id) {
		// TODO Auto-generated method stub
		return PrivilegeRepository.findById(id);
	}

	@Override
	@Cacheable(value = "privileges",unless = "#result.size() <1")
	public List<Privilege> findAll() {
		// TODO Auto-generated method stub
		return PrivilegeRepository.findAll();
	}
	
	@Override
	@Caching(evict = { @CacheEvict(value = "privileges", allEntries = true), @CacheEvict(value = "privilege", key="#privilegeId")})
	public void deletePrivilege(Long privilegeId) {
		// TODO Auto-generated method stub
		PrivilegeRepository.deleteById(privilegeId);
	}

	@Override
	@Caching(evict = { @CacheEvict(value = "privileges", allEntries = true), }, put = {@CachePut(value = "privilege", key = "#privilege.getId()") })
	public Privilege updatePrivilege(Privilege privilege) {
		// TODO Auto-generated method stub
		return PrivilegeRepository.save(privilege);
	}

	@Override
	@CachePut(value = "privilege",key = "#privilege.getId()")
	public Privilege addPrivilege(Privilege privilege) {
		// TODO Auto-generated method stub
		return PrivilegeRepository.save(privilege);
	}
	
	

}

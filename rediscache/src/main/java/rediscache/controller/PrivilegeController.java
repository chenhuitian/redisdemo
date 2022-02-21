package rediscache.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rediscache.entity.Privilege;
import rediscache.server.PrivilegeService;


@RestController
@RequestMapping("/privileges")
public class PrivilegeController {
	@Autowired
	PrivilegeService privilegeService;

	
	@GetMapping("/{id}")	
	public ResponseEntity<Optional<Privilege> > findById(@PathVariable Long id){
		return new ResponseEntity<Optional<Privilege>>(privilegeService.findById(id),HttpStatus.OK);
	}

	@GetMapping	
	public ResponseEntity<List<Privilege>> findAll(){
		return new ResponseEntity<List<Privilege>>(privilegeService.findAll(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Privilege> addPrivilege(@RequestBody Privilege privilege){
		return new ResponseEntity<Privilege>(privilegeService.addPrivilege(privilege),HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Privilege> updateById(@PathVariable Long id ,@RequestBody Privilege privilege) throws Exception{
		Optional<Privilege> privilegeOptional = privilegeService.findById(id);
		if(!privilegeOptional.isPresent()) {
			throw new Exception("no privilege");
		}
		Privilege oldPrivilege = privilegeOptional.get();
		oldPrivilege.setOperation(privilege.getOperation());
		return new ResponseEntity<Privilege>(privilegeService.updatePrivilege(oldPrivilege),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deletePrivilege(@PathVariable  long id){
		privilegeService.deletePrivilege(id);
		return new ResponseEntity<String>("delete success",HttpStatus.OK);
	}
}

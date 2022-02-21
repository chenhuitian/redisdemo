package rediscache.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8137235469729464124L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String userName;
	private String passWord;
	
//	@ManyToMany(mappedBy = "users",fetch = FetchType.LAZY)
	@ManyToMany(mappedBy = "users")
	@JsonIgnoreProperties(value={ "users" })
	private List<Role> roles;
//	
//	@ManyToMany(mappedBy = "privileges",fetch = FetchType.LAZY)
//	@JsonIgnoreProperties(value={ "users" })
//	private List<Role> privileges;
	

}

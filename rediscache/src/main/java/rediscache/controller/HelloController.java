package rediscache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.netty.handler.codec.base64.Base64;
import rediscache.entity.Privilege;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	
	
	@RequestMapping
	@Cacheable(cacheNames = "say")
	public String sayHello() {
		return "hello";
	}
	
	@RequestMapping("/cache/{key}")
	public String getDataString(@PathVariable String key){
		
//		String keyString = "privilege::".concat(privilegid);
//		keyString = "privilege::5";
////		String s =  redisTemplate.opsForValue().get(keyString).toString();
//		Object object = redisTemplate.opsForList().
//		Privilege s = (Privilege)redisTemplate.opsForValue().get(key) ;
		String s = (String)redisTemplate.opsForValue().get(key) ;
		return s;
	}
	
	@RequestMapping("/cache/ttl/{key}")
	public String getTTL(@PathVariable String key) {
		String ttlString =  redisTemplate.getExpire(key).toString();
		return ttlString;
	}
	
	@RequestMapping("/object/{key}")
	public Object getObjectString(@PathVariable String key){
		
//		String keyString = "privilege::".concat(privilegid);
//		keyString = "privilege::5";
////		String s =  redisTemplate.opsForValue().get(keyString).toString();
//		Object object = redisTemplate.opsForList().
		Object s = redisTemplate.opsForValue().get(key) ;
//		String s = (String)redisTemplate.opsForValue().get(key) ;
		return s;
	}
	
	@PostMapping("/cache/{key}")
	public String setDataString(@PathVariable String key){
		
		 redisTemplate.opsForValue().set(key, key);
		return "set redis key value";
		
	}
}

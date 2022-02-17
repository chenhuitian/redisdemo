package rediscache.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping
	@Cacheable(cacheNames = "say")
	public String sayHello() {
		return "hello";
	}
}

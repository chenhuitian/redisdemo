package rediscache.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
	Logger logger = LoggerFactory.getLogger(RedisConfig.class);
	
	//even redis can not access, could return data from database ignore exception
	@Bean
	@Override
	public CacheErrorHandler errorHandler() {
		CacheErrorHandler cacheErrorHandler = new CacheErrorHandler() {
			
			@Override
			public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
				// TODO Auto-generated method stub
				logger.error("redis exception : key=[{}]", key, exception);
			}
			
			@Override
			public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
				// TODO Auto-generated method stub
				logger.error("redis exception : key=[{}]", key, exception);
				
			}
			
			@Override
			public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
				logger.error("redis exception : key=[{}]", key, exception);
				
			}
			
			@Override
			public void handleCacheClearError(RuntimeException exception, Cache cache) {
				logger.error("redis exception:",  exception);
				
			}
		};
		return cacheErrorHandler;
	}
}

package com.example.online_market_project.redis_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class Redis_Config {
	
	@Bean
	public JedisConnectionFactory connectionFactory() {
		
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost",6379);
	RedisStandaloneConfiguration cloud_config = new RedisStandaloneConfiguration();
		
		cloud_config.setHostName("redis-16802.c73.us-east-1-2.ec2.redns.redis-cloud.com");
		cloud_config.setPassword("PGgsTPct2g4NpchP9shkROlQ24f25E4l");
		cloud_config.setUsername("default");
	    cloud_config.setPort(16802);
	    //return new JedisConnectionFcatory(config);
		return new JedisConnectionFactory(cloud_config);
	}
	
	
	 @Bean
	    public RedisTemplate<String, Object> redisTemplate() {
	        RedisTemplate<String, Object> template = new RedisTemplate<>();
	        template.setConnectionFactory(connectionFactory());
	        template.setKeySerializer(new StringRedisSerializer());
	        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
	        return template;
	    }

	   

	

	
	
	
	
	

}

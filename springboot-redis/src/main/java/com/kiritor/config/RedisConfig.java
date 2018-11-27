package com.kiritor.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.time.Duration;

@Configuration
@EnableCaching
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig extends CachingConfigurerSupport {

    private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);
    @Resource
    private LettuceConnectionFactory lettuceConnectionFactory;

    public RedisConfig() {
        logger.info("---------------RedisConfig容器启动初始化---------------");
    }

    /**
     * key生成策略
     *
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuffer sb = new StringBuffer();
                //sb.append(target.getClass().getSimpleName());
                sb.append("_");
                sb.append(params[0]);
                return sb.toString();
            }
        };
    }


    @Bean
    public CacheManager cacheManager() {
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(lettuceConnectionFactory);
        /* 默认配置， 默认超时时间为30s */
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(30L)).disableCachingNullValues();

        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        // 配置序列化
        RedisCacheConfiguration redisCacheConfiguration = defaultCacheConfig.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer)) .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer));

        // 设置一个初始化的缓存空间set集合
        //Set<String> cacheNames = new HashSet<>();
        //cacheNames.add("user");
        // 对每个缓存空间应用不同的配置
        //Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
        //configMap.put("user", defaultCacheConfig);
        return builder.cacheDefaults(defaultCacheConfig).build();
    }


    @Bean("redisTemplate")
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<String,Object>();
        Jackson2JsonRedisSerializer<Object> j = new Jackson2JsonRedisSerializer<Object>(Object.class);
        //设置序列化方式
        //value
        redisTemplate.setValueSerializer(j);
        redisTemplate.setHashKeySerializer(j);
        //key
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

}

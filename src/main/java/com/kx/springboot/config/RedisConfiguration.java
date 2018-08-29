package com.kx.springboot.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;


/**
 * Redis相关配置
 * Created by huangYi on 2018/3/18
 **/
@Configuration
public class RedisConfiguration extends CachingConfigurerSupport {
    //logger
    public static Logger logger = Logger.getLogger(RedisConfiguration.class);

    /**
     * 缓存管理器:
     * 要启用spring缓存支持,需创建一个 CacheManager的 bean，CacheManager 接口有很多实现，这里Redis 的集成，用 RedisCacheManager这个实现类
     * Redis 不是应用的共享内存，它只是一个内存服务器，就像 MySql 似的，我们需要将应用连接到它并使用某种“语言”进行交互,因此我们还需要一个连接工厂
     * 以及一个 Spring 和 Redis 对话要用的 RedisTemplate，这些都是 Redis 缓存所必需的配置，把它们都放在自定义的 CachingConfigurerSupport 中
     */
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        //设置缓存过期时间
//        cacheManager.setDefaultExpiration(10000);
//        return cacheManager;
//
//    }

//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory  redisConnectionFactory) {
//        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
//                .RedisCacheManagerBuilder
//                .fromConnectionFactory(redisConnectionFactory);
//        return builder.build();
//    }


    /**
     * 项目启动时此方法先被注册成bean被spring管理
     *
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        //设置序列化工具
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    /**
     * 重写key生成规则
     *
     * @return
     */
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                //格式化缓存key字符串
                StringBuilder sb = new StringBuilder();
                sb.append(12345);//追加类名
                sb.append(".");
                sb.append(method.getName());//追加方法名
                //遍历参数并追加
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                logger.info("调用Redis缓存key:" + sb.toString());
                return sb.toString();
            }
        };

    }


    /**
     * 重写key生成规则
     *
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator1() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                //格式化缓存key字符串
                StringBuilder sb = new StringBuilder();
                sb.append(7887987);//追加类名
                sb.append(".");
                sb.append(method.getName());//追加方法名
                //遍历参数并追加
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                logger.info("调用Redis缓存key:" + sb.toString());
                return sb.toString();
            }
        };

    }
}
package com.nhry.utils.redis;
import org.apache.log4j.Logger;

import com.nhry.common.auth.UserSessionService;
import com.nhry.utils.EnvContant;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * 
 * @author luofuchun
 *
 */
public class JedisPoolManager {
	private static final Logger LOGGER = Logger.getLogger(JedisPoolManager.class);
	public static final String REDIS_ADDRESS=EnvContant.getSystemConst("redisHost");
	public static final int REDIS_PORT=6379;
	public static final int REDIS_TIMEOUT=2000;
    
	static JedisPoolConfig config = new JedisPoolConfig();
    static JedisPool jedisPool =null;
    static Object syncObject=new Object();
    static boolean jedisPoolFlag =false; 
    static {
    	//连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
    	config.setBlockWhenExhausted(true);
    	//设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
    	config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
    	//是否启用pool的jmx管理功能, 默认true
    	config.setJmxEnabled(true);
    	//MBean ObjectName = new ObjectName("org.apache.commons.pool2:type=GenericObjectPool,name=" + "pool" + i); 默 认为"pool", JMX不熟,具体不知道是干啥的...默认就好.
    	config.setJmxNamePrefix("pool");
    	//是否启用后进先出, 默认true
    	config.setLifo(true);
    	//最大空闲连接数, 默认8个
    	config.setMaxIdle(3);
    	//最大连接数, 默认8个
    	config.setMaxTotal(3);
    	//获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
    	config.setMaxWaitMillis(-1);
    	//逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
    	config.setMinEvictableIdleTimeMillis(1800000);
    	//最小空闲连接数, 默认0
    	config.setMinIdle(0);
    	//每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
    	config.setNumTestsPerEvictionRun(3);
    	//对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数 时直接逐出,不再根据MinEvictableIdleTimeMillis判断  (默认逐出策略)   
    	config.setSoftMinEvictableIdleTimeMillis(1800000);
    	//在获取连接的时候检查有效性, 默认false
    	config.setTestOnBorrow(false);
    	//在空闲时检查有效性, 默认false
    	config.setTestWhileIdle(false);
    	//逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
    	config.setTimeBetweenEvictionRunsMillis(-1);
    }
	 
    public static Jedis getJedis() {
    	if (jedisPool==null){
    		synchronized (syncObject) {
    			if (!jedisPoolFlag){
            		jedisPool = new JedisPool(new JedisPoolConfig(),REDIS_ADDRESS,REDIS_PORT,REDIS_TIMEOUT);
            		jedisPoolFlag =true;
    			}
			}
    	}
    	Jedis jedis = jedisPool.getResource();
    	if(jedis == null){
    		LOGGER.error("获取redis连接异常"+jedis);
    	}
        return jedis;
	}
    
    public static void returnResource(Jedis jedis) {  
        if (jedis != null) {  
        	jedis.close();
        }  
    }  
}

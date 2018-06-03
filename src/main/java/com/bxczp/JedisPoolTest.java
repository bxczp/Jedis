package com.bxczp;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
    
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
//        设置最大连接数
        config.setMaxTotal(100);
//        设置最大空闲链接数
        config.setMaxIdle(10);
        
        JedisPool jedisPool = new JedisPool(config, "192.168.1.11", 6379);
        //创建变量
        Jedis jedis = null;
        try {
            //赋值变量
            jedis = jedisPool.getResource();
            jedis.auth("123456");
            jedis.set("value", "1111");
            System.err.println(jedis.get("value"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                //关闭连接
                jedis.close();
            }
            // 关闭连接池
            if (jedisPool != null) {
                jedisPool.close();
            }
            
            
        }
         
    }

}

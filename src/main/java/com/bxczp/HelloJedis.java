package com.bxczp;

import redis.clients.jedis.Jedis;

public class HelloJedis {
    
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.11", 6379);
//        Jedis密码
        jedis.auth("123456");
        jedis.set("name", "bxczp");
        System.out.println(jedis.get("name"));
        //关闭链接
        jedis.close();
    }
    

}

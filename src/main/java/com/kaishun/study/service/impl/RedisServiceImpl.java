package com.kaishun.study.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaishun.study.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:    RedisServiceImpl
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    private static final int expire = 604800;

    public RedisServiceImpl() {
    }

    @Override
    public void set(String key, Object value) {
        try {
            this.redisTemplate.opsForValue().set(key, this.objectMapper.writeValueAsString(value));
            if (this.get(key) == null) {
                this.set(key, value);
            }
        } catch (JsonProcessingException var4) {
            var4.printStackTrace();
        }

    }

    @Override
    public void hashSet(String key, Object hk, Object value) {
        try {
            this.redisTemplate.opsForHash().put(key, this.objectMapper.writeValueAsString(hk), this.objectMapper.writeValueAsString(value));
        } catch (JsonProcessingException var5) {
            var5.printStackTrace();
        }

    }

    @Override
    public void set(String key, Object value, long expireTime) {
        try {
            this.redisTemplate.opsForValue().set(key, this.objectMapper.writeValueAsString(value), expireTime, TimeUnit.SECONDS);
        } catch (JsonProcessingException var6) {
            var6.printStackTrace();
        }

    }

    @Override
    public boolean exists(final String key) {
        return this.redisTemplate.hasKey(key);
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        String s = this.get(key);
        if (s == null) {
            return null;
        } else {
            try {
                return this.objectMapper.readValue(s, clazz);
            } catch (IOException var5) {
                return null;
            }
        }
    }

    @Override
    public <T> T hashGet(String key, Object hk, Class<T> clazz) {
        String value = this.hashGet(key, hk);
        if (value == null) {
            return null;
        } else {
            try {
                return this.objectMapper.readValue(value, clazz);
            } catch (IOException var6) {
                var6.printStackTrace();
                return null;
            }
        }
    }

    @Override
    public String get(String key) {
        return key == null ? null : (String)this.redisTemplate.opsForValue().get(key);
    }

    @Override
    public String hashGet(String key, Object hk) {
        if (key != null && hk != null) {
            try {
                return (String)this.redisTemplate.opsForHash().get(key, this.objectMapper.writeValueAsString(hk));
            } catch (JsonProcessingException var4) {
                var4.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(String key) {
        return this.redisTemplate.delete(key);
    }

    @Override
    public long hashDelete(String key, Object hk) {
        return this.redisTemplate.opsForHash().delete(key, new Object[]{hk});
    }

    @Override
    public int getExpire() {
        return 604800;
    }

    @Override
    public void set(String key, String value) {
        this.redisTemplate.opsForValue().set(key, value);
        if (this.get(key) == null) {
            this.set(key, value);
        }

    }

    @Override
    public void set(String key, String value, long expireTime) {
        this.redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
        if (this.get(key) == null) {
            this.set(key, value, expireTime);
        }

    }
}

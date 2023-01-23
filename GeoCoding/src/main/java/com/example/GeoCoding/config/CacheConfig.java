package com.example.GeoCoding.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;


@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public Caffeine caffeineConfig () {
        return Caffeine.newBuilder().maximumSize(10000).recordStats().expireAfterAccess(25, TimeUnit.MINUTES);
    }
    @Bean
    public CacheManager cacheManager (Caffeine caffeine) {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }

}

package com.example.demo.configs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        final Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dk3t3pii9");
        config.put("api_key", "792859516183668");
        config.put("api_secret", "RFFgGW6E8Zcow4xpRt_CzEPjCrw");
        return new Cloudinary(config);
    }
}
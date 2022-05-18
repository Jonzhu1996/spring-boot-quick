package com.quick.db.crypt.config;

import com.quick.db.crypt.encrypt.AesSupport;
import com.quick.db.crypt.encrypt.Encrypt;
import com.quick.db.crypt.intercept.CryptReadInterceptor;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EncryptPluginConfig {


    @Bean
    Encrypt encryptor() throws Exception {
        return new AesSupport("1870577f29b17d6787782f35998c4a79");
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() throws Exception {
        CryptReadInterceptor decryptReadInterceptor = new CryptReadInterceptor(encryptor());

        return (configuration) -> {
            configuration.addInterceptor(decryptReadInterceptor);
        };
    }
}
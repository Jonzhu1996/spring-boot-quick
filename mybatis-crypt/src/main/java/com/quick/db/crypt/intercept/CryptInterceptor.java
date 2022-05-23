package com.quick.db.crypt.intercept;

import com.quick.db.crypt.encrypt.AesDesDefaultEncrypt;
import com.quick.db.crypt.encrypt.Encrypt;
import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchAlgorithmException;

@Slf4j
public abstract class CryptInterceptor {

    protected Encrypt encrypt;

    public CryptInterceptor(Encrypt encrypt) {
        log.warn("使用自定义的Encrypt，需要确保写入和读取方为同一个Encrypt,否则将会出现加解密失败的情况！！！");
        this.encrypt = encrypt;
    }
}

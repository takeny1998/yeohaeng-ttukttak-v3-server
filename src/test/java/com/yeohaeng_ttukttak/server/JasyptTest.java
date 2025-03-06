package com.yeohaeng_ttukttak.server;

import org.assertj.core.api.Assertions;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JasyptTest {

    private static final StandardPBEStringEncryptor stringEncryptor = new StandardPBEStringEncryptor();

    @BeforeAll
    static void init() {
        final SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(getEnvOrDefault("JASYPT_PASSWORD", "password"));

        stringEncryptor.setConfig(config);
    }

    @Test
    void stringTest() {
        // Given
        final String string = getEnvOrDefault("WILL_ENCRYPT", "encrypt_value");
        final String encrypted = stringEncryptor.encrypt(string);
        System.out.println("encrypted = " + encrypted);

        // When
        final String decrypted = stringEncryptor.decrypt(encrypted);

        // Then
        Assertions.assertThat(decrypted).isEqualTo(string);
    }

    private static String getEnvOrDefault(String key, String defaultValue) {
        final String env = System.getenv(key);
        return env != null ? env : defaultValue;
    }

}

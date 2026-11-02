package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {

    private static final Properties properties = new Properties();

    private TestConfig() {
    }

    static {
        try (InputStream inputStream = TestConfig.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (inputStream == null) {
                throw new IllegalStateException("config.properties not found");
            }
            properties.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getBaseUrl() {
        String baseUrl = properties.getProperty("baseUrl");

        if (baseUrl == null || baseUrl.isBlank()) {
            throw new IllegalStateException("baseUrl is missing in config.properties");
        }

        return baseUrl;
    }
}
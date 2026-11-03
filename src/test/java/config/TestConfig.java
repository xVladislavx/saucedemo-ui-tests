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
        return getRequiredProperty("baseUrl");
    }

    public static String getBrowser() {
        return getRequiredProperty("browser");
    }

    public static boolean isHeadless() {
        String isHeadless = getRequiredProperty("headless");

        if (!(isHeadless.equalsIgnoreCase("true") || isHeadless.equalsIgnoreCase("false"))) {
            throw new IllegalStateException("Property 'headless' must be 'true' or 'false', but was: " + isHeadless);
        }
        return Boolean.parseBoolean(isHeadless);
    }

    public static long getTimeout() {
        return Long.parseLong(getRequiredProperty("timeout"));
    }

    public static String getBrowserSize() {
        return getRequiredProperty("browserSize");
    }

    private static String getRequiredProperty(String property) {
        String value = properties.getProperty(property);

        if (value == null || value.isBlank()) {
            throw new IllegalStateException(String.format("Property '%s' is missing in config.properties", property));
        }

        return value;
    }
}
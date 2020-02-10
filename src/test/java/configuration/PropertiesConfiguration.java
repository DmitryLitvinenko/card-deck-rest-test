package configuration;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesConfiguration {
    private static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";

    private static Properties prop = new Properties();

    private PropertiesConfiguration() {}

    public static String getCardDeckUrl() { return getProperty("card.deck.api.url"); }

    public static String getShuffleUrlPath() { return getProperty("card.deck.api.shuffle.path"); }

    @SneakyThrows
    private static String getProperty(String property) {
        prop.load(new FileInputStream(CONFIG_FILE_PATH));
        return prop.getProperty(property);
    }
}

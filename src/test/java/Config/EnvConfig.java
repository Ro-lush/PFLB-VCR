package Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvConfig {
    public final String env;
    public final String baseUrl;
    public final String username;
    public final String userPassword;
    public final String apiUrl;
    public final String urlClient;
    public final String urlClientProfile;
    public final String urlClientTariff;
    public final String urlFAQ;
    public final String urlPrice;
    public final String orderID;
    public final String urlMetrics;


    private static final String ENV_NAME = "ACTIVE_ENVIRONMENT";

    public EnvConfig() {

        String getenv = System.getenv(ENV_NAME);
        if (getenv == null) env = "conf";
        else env = getenv;
        Properties properties = parseProperties();
        this.baseUrl = properties.getProperty("url");
        this.username =  properties.getProperty("loginClient");
        this.userPassword = properties.getProperty("password");
        this.apiUrl = properties.getProperty("urlAPI");
        this.urlClient = properties.getProperty("urlClient");
        this.urlClientProfile = properties.getProperty("urlClientProfile");
        this.urlClientTariff = properties.getProperty("urlClientTariff");
	    this.urlFAQ = properties.getProperty("urlFAQ");
        this.orderID = properties.getProperty("orderId");
        this.urlPrice = properties.getProperty("urlPrice");
        this.urlMetrics = properties.getProperty("urlMetrics");

    }
    public Properties parseProperties() {

        try (
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream(env + ".properties")
        ) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

package ebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    // Properties instance to read configuration properties
    Properties pro;

    // Constructor to initialize the Properties and load the configuration file
    public ReadConfig() {
        // Define the path to the configuration file
        File src = new File("C:\\Users\\LEGION\\eclipse-workspace\\ebankingV1\\Configuration\\config.properties");

        try {
            // Create FileInputStream for the configuration file
            FileInputStream fis = new FileInputStream(src);

            // Initialize Properties and load the configuration file
            pro = new Properties();
            pro.load(fis);

        } catch (Exception e) {
            // Print an error message if an exception occurs while reading the configuration file
            System.out.println("The exception is: " + e.getMessage());
        }
    }

    // Method to get the application URL from the configuration
    public String getapplicationURL() {
        String link = pro.getProperty("URL");
        return link;
    }

    // Method to get the application username from the configuration
    public String getapplicationusername() {
        String name = pro.getProperty("un");
        return name;
    }

    // Method to get the application password from the configuration
    public String getapplicationpassword() {
        String mdp = pro.getProperty("pw");
        return mdp;
    }

    // Method to get the path of the ChromeDriver from the configuration
    public String getapplicationchromedriver() {
        String path = pro.getProperty("chromepath");
        return path;
    }
}

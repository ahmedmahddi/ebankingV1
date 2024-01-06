package ebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{
		File src= new File("C:\\Users\\LEGION\\eclipse-workspace\\ebankingV1\\Configuration\\config.properties");
		
		try {
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("the exception is"+ e.getMessage());
		}
	}

	public String getapplicationURL() {
		String link=pro.getProperty("URL");
		return link;
		
	}
	public String getapplicationusername() {
		String name=pro.getProperty("un");
		return name;
	}
	public String getapplicationpassword() {
		String mdp=pro.getProperty("pw");
		return mdp;
	}
	public String getapplicationchromedriver() {
		String path=pro.getProperty("chromepath");
		return path;
	}

}
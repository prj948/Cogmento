package BaseLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
	protected static Properties prop;

	public BaseClass()  {
		String destpath = System.getProperty("user.dir") + "/src/main/java/ConfigLayer/config.properties";
		try {
			FileInputStream fis = new FileInputStream(destpath);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static ThreadLocal<WebDriver> threadlocal = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return threadlocal.get();
	}
 public static void initilization(String browsername) {
	 WebDriver driver=null;
	 
	 if(browsername.equalsIgnoreCase("chrome")) {
		 driver=new ChromeDriver();
		 threadlocal.set(driver);
	 }
	 else if(browsername.equalsIgnoreCase("edge")) {
		 driver=new EdgeDriver();
		 threadlocal.set(driver);
	 }
	 else if(browsername.equalsIgnoreCase("--incognito")) {
		driver=new ChromeDriver(new ChromeOptions().addArguments("--incognito"));
		 threadlocal.set(driver);
	 }
	 else if(browsername.equalsIgnoreCase("--headless")) {
			driver=new ChromeDriver(new ChromeOptions().addArguments("--headless"));
			 threadlocal.set(driver);
		 }
	 else {
		 System.out.println("give the proper Browsername");
	 }
	 getDriver().manage().window().maximize();
	 getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)).implicitlyWait(Duration.ofSeconds(30));
	 getDriver().manage().deleteAllCookies();
	 getDriver().get(prop.getProperty("url"));
}
}

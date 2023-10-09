package TravelBase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import ElementClass.HomeScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class DeviceConfig {
	public static AndroidDriver driver;
	public static WebDriverWait wait;
	public static HomeScreen homescreen;
	public String date;
	 
	private AppiumDriverLocalService server;
	
	@BeforeSuite
	public void Set_up() throws MalformedURLException, InterruptedException
	{
		//Start Appium session programatically
		AppiumSessionStart();
		
		//location of the app
		File app = new File("ApkFile", "app-release.apk");
		//File app = new File("ApkFile", "Demo.apk");
		 
		 //To create an object of Desired Capabilities
		 DesiredCapabilities capability = new DesiredCapabilities();
		//OS Name
		 capability.setCapability("app", app.getAbsolutePath());
		 capability.setCapability("deviceName","Galaxy A52s 5G");
		 capability.setCapability("platformVersion","11");
		 capability.setCapability("udid","RZ8M513F02X");
		 capability.setCapability("platformName", "Android");
		 capability.setCapability("automationName","UiAutomator2");
		 capability.setCapability("autoGrantPermissions", "true");
				 
		 URL url = new URL("http://127.0.0.1:4723/wd/hub");
		 driver  = new AndroidDriver(url,capability);
		 wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		 driver.setFileDetector(new LocalFileDetector());
		 
		 System.out.println("\n [*]App launched for the automation");
		 homescreen = new HomeScreen(driver);
	 }

	public void AppiumSessionStart()
	{
		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder
        		.usingDriverExecutable(new File("/usr/local/bin/node"))
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                .withArgument(GeneralServerFlag.USE_DRIVERS,"uiautomator2@2.29.4")
                .withArgument(GeneralServerFlag.USE_PLUGINS,"execute-driver@3.0.16")
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withTimeout(Duration.ofMinutes(1));
        
		        HashMap<String, String> environment = new HashMap<String, String>();
		        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
		        serviceBuilder.withEnvironment(environment);
        
                server = AppiumDriverLocalService.buildService(serviceBuilder);
                server.start();
                System.out.println("\nAppium server started..");
   
	}
	@AfterSuite
	public void StopAppium() {
		server.stop();
		System.out.println("Appium server stop..");
	} 
	public String dateformater() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM, d,");
		LocalDateTime now = LocalDateTime.now();
		return date = dtf.format(now);			
	}
}

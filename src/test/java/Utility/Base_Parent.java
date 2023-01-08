package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Parent {
	
	// We will have Constructor: Special type of Method which is initialize the value.
	// We will initialize some config files values here.
	// We going to use Apachi POI(Maven Product):is an interface, this interface gives us a class called
	// fileinputstring class which is responsible for read the values from config files.  
	//Apachi POI(Maven Product): also gives us a class called fileoutputstring class which is reponsible for 
	// writung into the config files. 
	
	// We will use another class called properties class which is given by JAVA. Its help us to distributes values 
	// in the test cases. 
	
	
	// Construction Rules: 1. Should be the same name as class name. 2. Should not have any return type.
	// We will have Method for Browser Initialization 
	// We will have Method for Launching our URL
	
	public static Properties metaprop;
	public static WebDriver driver;
	
	public Base_Parent ( ) {
		try {
			FileInputStream files = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java/com\\nexttechmeta\\config\\MetaConfig.Properties");
			
			metaprop = new Properties(); 
			metaprop.load(files);
		} catch (FileNotFoundException e) {
			System.out.println("Please check your Constructor");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void metabrowserinit() {
		
	  String metabrowser =	metaprop.getProperty("Browser1");
	  
	  if (metabrowser.equalsIgnoreCase("Chrome")) {
		  
		  
				
				 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\DriverforChrome\\chromedriver.exe" );
				driver= new ChromeDriver ();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Test_Data.implicitywait)); // wait time before start anything
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Test_Data.pageloadwait)); // wait time for page load
				
	  }
	  
	  else if (metabrowser.equalsIgnoreCase("FireFox") ) {
		  
		  System.out.println("This is FireFox Browser");
		  
	  }
	  
			  
	  }
		
	 public static void metaLaunchURL(String URL) {
		 
		 
		
		 
		 // driver.get(metaprop.getProperty("URL1"));
		 
		 driver.get(metaprop.getProperty("URL1"));
		  
	  }
		
	}



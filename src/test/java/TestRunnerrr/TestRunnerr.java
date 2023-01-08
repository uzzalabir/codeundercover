package TestRunnerrr;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utility.Base_Parent;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//cucumber options
@CucumberOptions(features={"src/test/resources/Feature_Files"},
plugin={"json:targer/cucumber.json"},
glue="StepDeffination")  // , tags= {"@YY"}) // tags is responsible to run specific test case


public class TestRunnerr extends AbstractTestNGCucumberTests {
	
	@BeforeTest
	public void metasetup () {
		
		Base_Parent test = new Base_Parent ();
		test.metabrowserinit();
		
		
	}
	
	@AfterTest
	
	public void metacloseURL () {
		
		Base_Parent test = new Base_Parent ();
		
	 test.driver.quit();
		
		
		
	}

}

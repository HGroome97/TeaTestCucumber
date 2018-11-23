package Tests.com.qa.TeaTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")
public class TeaTest {
	public static ExtentReports report;
	
	
	@BeforeClass
    public static void setUp(){
		report = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\TeaTest\\BasicReport.html", true);
    }

    @AfterClass
    public static void tearDown(){
    	report.flush();
    }
}
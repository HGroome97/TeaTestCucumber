package Tests.com.qa.TeaTest;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.CheckoutPage;
import Pages.Homepage;
import Pages.Menupage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TeaSteps {
	
	TeaTest tt = new TeaTest();
	ExtentTest test;
	WebDriver driver;
	Homepage homepage;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\External Apps\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
		tt.report.endTest(test);
	}
	

	@Given("^the correct web address$")
	public void the_correct_web_address() {
		driver.get("http://www.practiceselenium.com");	
		homepage = PageFactory.initElements(driver, Homepage.class);
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {
		homepage.clickMenu();
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
		test = tt.report.startTest("Verify Menu Link");
		Menupage page = PageFactory.initElements(driver, Menupage.class);
		
		if (page.getMenuTitle().equals("Menu")) {
			test.log(LogStatus.PASS, "Menu Link correctly connects");
		} else {
			test.log(LogStatus.FAIL, "Failure linking to menu page");
		}
		
		Assert.assertEquals("menu available" , "Menu",  page.getMenuTitle());
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
		homepage.clickCheckout();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
		test = tt.report.startTest("Verify Checkout Link");
		CheckoutPage page = PageFactory.initElements(driver, CheckoutPage.class);
		
		if (page.getCheckoutTitle().equals("Pay with Credit Card or Log In")) {
			test.log(LogStatus.PASS, "Checkout Link correctly connects");
		} else {
			test.log(LogStatus.FAIL, "Failure linking to checkout page");
		}
		
		Assert.assertEquals("checkout available" , "Pay with Credit Card or Log In",  page.getCheckoutTitle());
	}
	
}

package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {
	
	@FindBy(xpath = "//*[@id='wsb-element-00000000-0000-0000-0000-000451989411']/div/p/span/strong")
	private WebElement CheckoutTitle;
	
	public String getCheckoutTitle() {
		return CheckoutTitle.getText();
	}
}

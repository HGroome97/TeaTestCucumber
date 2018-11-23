package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menupage {
	
	@FindBy(xpath = "//*[@id='wsb-element-00000000-0000-0000-0000-000450914921']/div/h1")
	private WebElement MenuTitle;
	
	public String getMenuTitle() {
		return MenuTitle.getText();
	}
}

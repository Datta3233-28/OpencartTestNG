package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
WebDriver driver;
public LoginPage(WebDriver driver) {
	super(driver);
}
@FindBy(xpath="//input[@id='input-email']")
WebElement txtemailid;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtpass;

@FindBy(xpath="//input[@type='submit']")
WebElement btnsubmit;

public void emailtext(String email) {
	txtemailid.sendKeys(email);
}
public void passwordtext(String pass) {
	txtpass.sendKeys(pass);
}
public void clickonsubmit() {
	btnsubmit.click();
}
}

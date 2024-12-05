package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {

	public AccountRegisterPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtinputemail;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtinputtelephone;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtinputpassword;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtinputconfirm;
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkbox;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncountinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement megConfirmed;
	
	public void setFirstName(String fname) {
		txtfirstname.sendKeys(fname);
	}
	public void setLasName(String lname) {
		txtlastname.sendKeys(lname);
	}
	public void setemail(String email) {
		txtinputemail.sendKeys(email);
	}
	public void setTelephone(String telephone) {
		txtinputtelephone.sendKeys(telephone);
	}
	public void setPassword(String password) {
		txtinputpassword.sendKeys(password);
	}
	public void setConfirmedPassword(String confirm) {
		txtinputconfirm.sendKeys(confirm);
	}
	public void checkboxselect() {
		checkbox.click();;
	}

	public void countinuebuttonselect() {
		btncountinue.click();;
	}
	public String getConfirmstionMsg() {
		try {
			return(megConfirmed.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
	
}

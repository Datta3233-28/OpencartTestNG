package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegisterPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class Tc001AccountRegistrationTest extends BaseClass{

@Test()
public void verify_account_registertion() {
	try{
		logger.info("**********Strating Tc001AccountRegistrationTest******");
	
	HomePage hp=new HomePage(driver);
	hp.clickMyaccount();
	logger.info("clickMyaccount");
	hp.clickRegister();
	logger.info("clickRegister");
	AccountRegisterPage ap=new AccountRegisterPage(driver);
	logger.info("provding details");
	ap.setFirstName("datta");
	ap.setLasName("raut");
	ap.setemail(randomString()+"@gmail.com");
	ap.setTelephone(randomNumber());
	String password=randomAlphaNumberic();
	ap.setPassword(password);
	ap.setConfirmedPassword(password);
	ap.checkboxselect();
	ap.countinuebuttonselect();
	logger.info("verify the message");
	String confmag=ap.getConfirmstionMsg();
	Assert.assertEquals(confmag, "Your Account Has Been Created!");
	}
	catch(Exception e){
		logger.error("test failed");
		logger.debug("debug log");
		Assert.fail();
	}
	logger.info("**********end Tc001AccountRegistrationTest******");
}

}

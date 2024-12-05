package testCase;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;




public class Tc002_LoginTest extends BaseClass {

	@Test
	public void verify_login() {
		//logger.info("**************Start-2*****************");
		//Home page
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickonlogin();
		
		//loginpage
		LoginPage lp=new LoginPage(driver);
		lp.emailtext(p.getProperty("email"));
		lp.passwordtext(p.getProperty("password"));
		lp.clickonsubmit();
		//Myacoount page
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true,"login fail");
		}
		catch(Exception e){
			Assert.fail();
		}
		
	}
}

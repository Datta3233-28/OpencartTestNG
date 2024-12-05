package testCase;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import uitilities.DataProviders;


	/*Data is valid  - login success - test pass  - logout
	 					login failed - test fail

	Data is invalid - login success - test fail  - logout
	 					login failed - test pass
	*/


	public class Tc003_LoginDDT extends BaseClass {

		@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")// getting data provider from different class
		public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException
		{
			logger.info("***** stating TC_003_LoginDDT ******");
			
			try
			{
			//HomePage
			HomePage hp=new HomePage(driver);
			hp.clickMyaccount();
			hp.clickonlogin();
			
			//Login
			LoginPage lp=new LoginPage(driver);
			lp.emailtext(email);
			lp.passwordtext(exp);
			lp.clickonsubmit();
				
			//MyAccount
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExists();
			
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{			
					macc.clickonlogout();
					Assert.assertTrue(true);
					
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					macc.clickonlogout();
					Assert.assertTrue(false);
					
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			
			}catch(Exception e)
			{
				Assert.fail();
			}
			Thread.sleep(3000);
			logger.info("***** Finished TC_003_LoginDDT ******");
			
		}
		
	}












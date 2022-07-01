package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC_001_AccountRegistration extends BaseClass
{

	
	
	@Test(priority=1)
	public void test_account_registration() throws InterruptedException
	{
		//logger.info(" Starting TC_001_AccountRegistration ");
		logger.info("****** Starting "+logger.getName()+" ******");
		try
		{		
			//driver.get("http://localhost/opencart/upload/");
			driver.get(rb.getString("appURL"));  // Get the appURL value from config.properties file
			logger.info("Home Page Displayed");
			
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account");
			
			hp.clickRegister();
			logger.info("Clicked on Register");
			
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			regpage.setFirstName("Hello");
			logger.info("Provided First Name ");
			
			regpage.setLastName("World");
			logger.info("Provided Last Name ");
			
			//regpage.setEmail(randomString()+"@email.com");
			regpage.setEmail("xyzemail.com");
			logger.info("Provided Email ");
			
			regpage.setTelephone("123456");
			logger.info("Provided Telephone ");
			
			regpage.setPassword("hello123");
			regpage.setConfirmPassword("hello123");
			logger.info("Provided Passwords ");
			
			regpage.setPrivacyPolicy();
			logger.info("Acknowledged Policy ");
			
			Thread.sleep(5);
			
			regpage.clickContinue();
			logger.info("Clicked on Continue ");
			
			Thread.sleep(5);
			
			String confmsg=regpage.getConfirmationMsg();
			
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				logger.info("Account Registration Success ");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Account Registration Failed ");
				captureScreen(driver, "test_account_registration"); //Capturing screenshot
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			logger.fatal("FATAL: Account Registration Failed ");
			Assert.fail();
		}
		
		logger.info("****** Finished "+logger.getName()+" ******");
	}
	
	
}

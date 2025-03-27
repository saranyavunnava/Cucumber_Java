package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginSteps extends BaseClass {
	// WebDriver driver;
	LoginPage lp;

	@Before
	public void launchBrowser() throws InterruptedException, FileNotFoundException {
		logger = LogManager.getLogger(this.getClass());
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			throw new FileNotFoundException("properties file doesnt exists");
		}
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/sures/eclipse-workspace/Cucumber_Framework/Drivers/chromedriver.exe");
		switch (prop.getProperty("browser")) {
		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "Edge":
			driver = new EdgeDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		default:
			throw new InvalidArgumentException("browser name is not valid");
		}
		logger.info("launched browser...");
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}

	@Given("user Opens the Url {string}")
	public void user_opens_the_url(String url) throws InterruptedException {
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		logger.info("Opening the application url...");
	}

	@When("clicks on Login link")
	public void clicks_On_Login_link() {
		lp = new LoginPage(driver);
		lp.clickMyAccountLink();
		lp.clickLoginLink();
		logger.info("clicked on login link....");
	}

	@And("user enters Email as {string} and password as {string}")
	public void userEnters_Email_and_Password(String email, String pwd) {
		System.out.println("email is....." + email);
		lp.setUserName(email);
		lp.setPassword(pwd);

	}

	@And("click on Login button")
	public void clickLoginButton() {
		lp.clickLogin();
	}

	@When("user click on Logout link")
	public void click_Logout_link() {
		// lp.clickLogoutLink();

	}

	@Then("Page title should be {string}")
	public void verify_page_title(String title) {
		String pageTitle = lp.getTitle();
		Assert.assertEquals(title, pageTitle);
	}
	@Then("application should throw error")
	public void application_throw_Error() {
		Assert.assertTrue(false);
	}
	// @And("close the browser")
	@After
	public void closeBrowser() {

		// driver.quit();
	}
}

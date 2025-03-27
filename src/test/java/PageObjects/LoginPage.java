package PageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@title='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath = "//li//a[normalize-space()='Login']")
	@CacheLookup
	WebElement loginLink;

	@FindBy(xpath = "//*[@id='input-email']")
	@CacheLookup
	WebElement email;

	@FindBy(id = "input-password")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//*[@type='submit']")
	@CacheLookup
	WebElement loginBtn;

	@FindBy(xpath = "//li//a[normalize-space()='Logout']")
	@CacheLookup
	WebElement logOutLink;

	@FindBy(xpath = "//a[normalize-space()='Forgotten Password']")
	@CacheLookup
	WebElement forgotPwd;

	public void clickMyAccountLink() {
		/*
		 * JavascriptExecutor js=(JavascriptExecutor)ldriver;
		 * js.executeScript("arguments[0].click();", lnkMyAccount);
		 */	
		lnkMyAccount.click();
	}
	public void clickLoginLink() {
		try {
			if (loginLink.isDisplayed()) {
				loginLink.click();
			}
		} catch (Exception e) {
			throw new NoSuchElementException("Login link element doesnt exists");
		}
	}

	public void setUserName(String userName) {
		try { if(email.isDisplayed()) {
		email.clear();
		email.sendKeys(userName);}}catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void setPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}

	public void clickLogin() {
		loginBtn.click();
		
	}
	
	public String getTitle() {
		return driver.getTitle();
		 
	}

	public void forgotPwdLink() {
		forgotPwd.click();
	}

	public void clickLogoutLink() {
		try {
			if (logOutLink.isDisplayed()) {
				logOutLink.click();
			}
		} catch (NoSuchElementException | ElementNotInteractableException e) {
			throw new NoSuchElementException("Logout link element doesnt exists");
		}
		{

		}
	}
}

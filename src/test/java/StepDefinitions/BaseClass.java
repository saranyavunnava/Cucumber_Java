package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;

public class BaseClass {
	public static WebDriver driver;

public static Logger logger;	
Properties prop;
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20) );


}

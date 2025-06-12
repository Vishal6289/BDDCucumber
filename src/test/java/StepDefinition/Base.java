package StepDefinition;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Base {

    public static WebDriver driver;
    public LoginPage loginpage;
    public SearchCustomerPage searchCustomerPage;
    public AddNewCustomerPage addNewCustomerPage;
    public static Logger log;
    public static Properties readconfig;

    public Base()
    {
        try
        {
            readconfig = new Properties();
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            readconfig.load(fileInputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization()
    {
        String BrowserName= readconfig.getProperty("browser");
        if(BrowserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver=new ChromeDriver(options);
        }
        else if (BrowserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }



    public String gererateEmailID(){
        return RandomStringUtils.randomAlphabetic(5);
    }
}

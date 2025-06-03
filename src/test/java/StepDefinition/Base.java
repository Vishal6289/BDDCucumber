package StepDefinition;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class Base {

    public WebDriver driver;
    public LoginPage loginpage;
    public SearchCustomerPage searchCustomerPage;
    public AddNewCustomerPage addNewCustomerPage;

    public String gererateEmailID(){
        return RandomStringUtils.randomAlphabetic(5);
    }
}

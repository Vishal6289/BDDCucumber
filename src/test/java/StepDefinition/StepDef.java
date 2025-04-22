package StepDefinition;

import PageObject.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;


public class StepDef {
    public WebDriver driver;
    public LoginPage loginpage;
    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();

        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginpage=new LoginPage(driver);
    }
    @When("User opens url {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }
    @When("User enter email {string} and password {string}")
    public void user_enter_email_and_password(String emailID, String pwd) {
        System.out.println("Trying to enter email");
        loginpage.enterEmail(emailID);
        loginpage.enterPassord(pwd);
    }
    @When("User clicks on Login Button")
    public void user_clicks_on_login_button() {
        loginpage.clickOnLoginButton();

    }
    @Then("Page title should be {string}")
    public void page_title_should_be(String ExpectedTitle) {
        String ActualTitle=driver.getTitle();
        if(ActualTitle.equals(ExpectedTitle))
        {
            Assert.assertTrue(true);//pass
        }
        else
        {
            Assert.assertTrue(false);//false
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @When("User click on logout button")
    public void user_click_on_logout_button() {
        loginpage.clickOnLogoutButton();

    }
    @Then("Close the browser")
    public void close_the_browser() {
        driver.quit();

    }
}

package StepDefinition;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;


public class StepDef {
    public WebDriver driver;
    public LoginPage loginpage;
    public SearchCustomerPage searchCustomerPage;
    public AddNewCustomerPage addNewCustomerPage;

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        WebDriverManager.firefoxdriver().setup();
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
        loginpage.enterEmail(emailID);
        loginpage.enterPassord(pwd);
    }
    @When("User clicks on Login Button")
    public void user_clicks_on_login_button() {
        loginpage.clickOnLoginButton();

    }
    /////////////////////Login feature//////////////////////////////
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
    @Then("close the browser")
    public void close_the_browser() {
        driver.quit();
    }



//////////Add new customer///////////////

    @Then("User can see Dashboard")
    public void user_can_see_dashboard() {
        String actualtitle=addNewCustomerPage.getPageTitle();
        String expectedtitle="Dashboard / nopCommerce administration";
        Assert.assertEquals(actualtitle,expectedtitle);
    }

    @When("User clicks on Customer menu")
    public void user_clicks_on_customer_menu() {
        addNewCustomerPage.clickOnCustomersMenu();
    }

    @When("clicks on Customers menu item")
    public void clicks_on_customers_menu_item() {
      addNewCustomerPage.clickOnCustomersMenuItem();
    }

    @When("User clicks on Add new button")
    public void user_clicks_on_add_new_button() {
       addNewCustomerPage.clickOnAddnew();
    }

    @Then("User can see Add mew customers page")
    public void user_can_see_add_mew_customers_page() {
        String actualtitle=addNewCustomerPage.getPageTitle();
        String expectedtitle="Dashboard / nopCommerce administration";
        Assert.assertEquals(actualtitle,expectedtitle);
    }

    @When("User enter customer info")
    public void user_enter_customer_info() {
        addNewCustomerPage.enterEmail("test1@gmail.com");
        addNewCustomerPage.enterPassword("Test1");
        addNewCustomerPage.enterFirstName("Vishal");
        addNewCustomerPage.enterLastName("Sharma");
        addNewCustomerPage.enterGender("Male");
        addNewCustomerPage.enterCompanyName("Hashcash");
        addNewCustomerPage.enterAdminContent("Admin Content");
        addNewCustomerPage.enterManagerOfVendor("Vendor 1");
    }

    @When("Clicks on Save Button")
    public void clicks_on_save_button() {
     addNewCustomerPage.clickOnSave();
    }

    @Then("User can see confirmation message {string}")
    public void user_can_see_confirmation_message(String ExpectedConfimationMessage) {

        String Bodytagtext=driver.findElement(By.tagName("Body")).getText();
        if(Bodytagtext.contains(ExpectedConfimationMessage))
        {
            Assert.assertTrue(true);//pass
        }
        else
        {
            Assert.assertTrue(false);//fail
        }
    }

    /////////////////////SearchEmailAddress//////////////////////////////
    @When("Enter customer email")
    public void enter_customer_email() {
     searchCustomerPage.enterEmailAdd("james_pan@nopCommerce.com");
    }

    @When("Click on search button")
    public void click_on_search_button() {
        searchCustomerPage.clickOnSearchButton();
    }

    @Then("User should foound the email in the search table")
    public void user_should_foound_the_email_in_the_search_table() {
        String expectedEmail= "james_pan@nopCommerce.com";
        searchCustomerPage.searchCustomerByemail(expectedEmail);
        Assert.assertTrue(searchCustomerPage.searchCustomerByemail(expectedEmail));

    }

}



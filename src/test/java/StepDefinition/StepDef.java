package StepDefinition;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.LogManager;


public class StepDef extends Base{

    @Before("@sanity")
    public void setup()
    {
        initialization();
//      log= LogManager.getLogger("StepDef");
        log.info("set executed..");
    }

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginpage=new LoginPage(driver);
        log.info("User launched browser..");
    }
    @When("User opens url {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        log.info("url opened");
    }
    @When("User enter email {string} and password {string}")
    public void user_enter_email_and_password(String emailID, String pwd) {
        loginpage.enterEmail(emailID);
        loginpage.enterPassord(pwd);
        log.info("email and password entered");
    }
    @When("User clicks on Login Button")
    public void user_clicks_on_login_button() {
        loginpage.clickOnLoginButton();
        log.info("clicked On LoginButton");
    }
    /////////////////////Login feature//////////////////////////////
    @Then("Page title should be {string}")
    public void page_title_should_be(String ExpectedTitle) {
        String ActualTitle=driver.getTitle();
        if(ActualTitle.equals(ExpectedTitle))
        {
            log.info("Test passed: login feature- page title matched");
            Assert.assertTrue(true);//pass
        }
        else
        {
            log.warn("Test failed:login feature- page title not matched");
            Assert.assertTrue(false);//false
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @When("User click on logout button")
    public void user_click_on_logout_button() {
        loginpage.clickOnLogoutButton();
        log.info("clicked On LogoutButton");

    }
    @Then("close the browser")
    public void close_the_browser() {
        driver.quit();
        log.info("closed the browser");

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
        log.info("clicked On customer menu");
        addNewCustomerPage.clickOnCustomersMenu();
    }

    @When("clicks on Customers menu item")
    public void clicks_on_customers_menu_item() {
        log.info("clicked On clicks on customers menu item");
        addNewCustomerPage.clickOnCustomersMenuItem();
    }

    @When("User clicks on Add new button")
    public void user_clicks_on_add_new_button() {
       addNewCustomerPage.clickOnAddnew();
        log.info("clicked On add new button");
    }

    @Then("User can see Add mew customers page")
    public void user_can_see_add_mew_customers_page() {
        String actualtitle=addNewCustomerPage.getPageTitle();
        String expectedtitle="Dashboard / nopCommerce administration";
        Assert.assertEquals(actualtitle,expectedtitle);
    }

    @When("User enter customer info")
    public void user_enter_customer_info() {
        addNewCustomerPage.enterEmail(gererateEmailID()+"@gmail.com");
        addNewCustomerPage.enterPassword("Test1");
        addNewCustomerPage.enterFirstName("Vishal");
        addNewCustomerPage.enterLastName("Sharma");
        addNewCustomerPage.enterGender("Male");
        addNewCustomerPage.enterCompanyName("Hashcash");
        addNewCustomerPage.enterAdminContent("Admin Content");
        addNewCustomerPage.enterManagerOfVendor("Vendor 1");
        log.info("cust info entered");

    }

    @When("Clicks on Save Button")
    public void clicks_on_save_button() {
        log.info("clicked On save button");
        addNewCustomerPage.clickOnSave();
    }

    @Then("User can see confirmation message {string}")
    public void user_can_see_confirmation_message(String ExpectedConfimationMessage) {

            String Bodytagtext=driver.findElement(By.tagName("Body")).getText();
            if(Bodytagtext.contains(ExpectedConfimationMessage))
            {
                Assert.assertTrue(true);//pass
                log.info("user can see confirmation message passed");
            }
            else
            {
                Assert.assertTrue(false);//fail
                log.warn("user can see confirmation message failed");

            }
        }

    /////////////////////SearchEmailAddress//////////////////////////////
    @When("Enter customer email")
    public void enter_customer_email() {
     searchCustomerPage.enterEmailAdd("james_pan@nopCommerce.com");
        log.info("email entered");

    }

    @When("Click on search button")
    public void click_on_search_button() {
        searchCustomerPage.clickOnSearchButton();
        log.info("user clicked on search button");
    }

    @Then("User should foound the email in the search table")
    public void user_should_foound_the_email_in_the_search_table() {
        String expectedEmail= "james_pan@nopCommerce.com";
        searchCustomerPage.searchCustomerByemail(expectedEmail);
        Assert.assertTrue(searchCustomerPage.searchCustomerByemail(expectedEmail));

    }

    ////////////////////////////Search customer by Name//////////////////////////////////

    @When("Enter customer FirstName")
    public void enter_customer_first_name() {
        searchCustomerPage.enterFirstName("Victoria");
    }

    @When("Enter customer LastName")
    public void enter_customer_last_name() {
        searchCustomerPage.enterFirstName("Terces");
    }

    @Then("User should found the FirstName and LastName in the search table")
    public void user_should_found_the_first_name_and_last_name_in_the_search_table() {
        String expectedName= "Victoria Terces";
        Assert.assertTrue(searchCustomerPage.searchCustomerByName(expectedName));
    }
   @After(order =2)//or @sanity or @regression also can be written
    public void teardown1()
    {
        driver.quit();
    }
    @After(order =1)
    public void teardown2(Scenario sc)
    {
        System.out.println("Tear Down method executed");
        if(sc.isFailed()==true)
        {
            String Dest="C:\\Users\\visha\\OneDrive\\Desktop";
            File screenshotfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshotfile, new File(Dest));
            } catch (IOException e) {
                throw new RuntimeException(e);
            };

        }
        driver.quit();
    }

    @BeforeStep
    public void beforestepdemo()
    {
        System.out.println("This is before step .....");
    }
    @AfterStep
    public void afterstepdemo()
    {
        System.out.println("This is after step .....");
    }

}



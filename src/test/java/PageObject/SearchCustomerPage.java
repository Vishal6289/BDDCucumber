package PageObject;

import org.apache.velocity.runtime.directive.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SearchCustomerPage {

    public WebDriver ldriver;

    //constructor//

    public SearchCustomerPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);

    }

    @FindBy(id = "SearchEmail")
    WebElement emailId;

    @FindBy(id = "SearchFirstName")
    WebElement Fname;

    @FindBy(id = "SearchLastName")
    WebElement Lname;

    @FindBy(id = "search-customer")
    WebElement searchBtn;

    @FindBy(xpath = "//*[@id='customers-grid']/tbody/tr")
    List<WebElement> tableRows;

    @FindBy(xpath = "//*[@id='customers-grid']/tbody/tr[1]/td")
    List<WebElement> tableColumns;

    //Action method to enter email
    public void enterEmailAdd(String email) {
        emailId.sendKeys(email);
    }

    //Action method to preform search operation
    public void clickOnSearchButton() {
        searchBtn.click();
    }

    public boolean searchCustomerByemail(String email) {
        boolean found = false;
        for (int i = 1; i <= tableRows.size(); i++) {
            //fetching text of 2nd column of every row.
            String actualEmail = ldriver.findElement(By.xpath("//*[@id='customers-grid']/tbody/tr[i]/td[2]")).getText();
            if (actualEmail.equals(email)) {
                found = true;
            }
        }
        return found;
    }

/////////////////////Search Customer by Name///////////////////////////////
    public void enterFirstName(String Firstname) {
        Fname.sendKeys(Firstname);
    }
    public void enterLastName(String Lastname) {
        Fname.sendKeys(Lastname);
    }
    public boolean searchCustomerByName(String Name) {
        boolean found = false;
        for (int i = 1; i <= tableRows.size(); i++) {
            //fetching text of 2nd column of every row.
            String actualName = ldriver.findElement(By.xpath("//*[@id='customers-grid']/tbody/tr[i]/td[3]")).getText();
            if (actualName.equals(Name)) {
                found = true;
                break;
            }
        }
        return found;
    }


}

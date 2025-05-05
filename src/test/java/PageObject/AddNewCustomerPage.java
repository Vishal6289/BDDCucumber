package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage{
    public WebDriver ldriver;

    //constructor//

    public AddNewCustomerPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(ldriver, this);

    }

    //Find web elements in the webpage//

    @FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
    WebElement Customersmenu;

    @FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
    WebElement Customersmenu_Item;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement btnAddNew;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement txtFname;

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement txtLname;

    @FindBy(xpath = "//input[@id='Gender_Male']")
    WebElement Gender_Male;

    @FindBy(xpath = "//input[@id='Gender_Female']")
    WebElement Gender_Female;

    @FindBy(xpath = "//input[@id='Company']")
    WebElement Company;

    @FindBy(xpath = "//li[contains(text(),'Administrators')]")
    WebElement listItemAdministrators;


    @FindBy(xpath = "//li[contains(text(),'Registered')]")
    WebElement listItemRegistered;

    @FindBy(xpath = "//li[contains(text(),'Guests')]")
    WebElement listItemGuests;


    @FindBy(xpath = "//li[contains(text(),'Guests')]")
    WebElement listItemVendors;
    //VendorId

    @FindBy(xpath = "//*[@id='VendorId']")
    WebElement dropdownVendorMgr;


    @FindBy(xpath = "//input[@id='IsTaxExempt']")
    WebElement IsTaxExempt;

    @FindBy(xpath = "//span[@aria-expanded='true']//input[@role='searchbox']")
    WebElement Newsletter;

    @FindBy(xpath= "//span[@aria-expanded='true']//input[@role='searchbox']")
    WebElement Comp_Roles;

    @FindBy(xpath= "//input[@id=\"MustChangePassword\"]")
    WebElement ChangePass_Checkbox;

    @FindBy(xpath= "//textarea[@id='AdminComment']")
    WebElement AdminComment;

    @FindBy(xpath= "//button[@name='save']")
    WebElement btnSave;


    public String getPageTitle()
    {
        return ldriver.getTitle();
    }

    public void clickOnCustomersMenu() {
        Customersmenu.click();
    }

    public void clickOnCustomersMenuItem() {
        Customersmenu_Item.click();
    }

    public void clickOnAddnew() {
        btnAddNew.click();
    }

    public void enterEmail(String email)
    {
        txtEmail.sendKeys(email);
    }

    public void enterPassword(String password)
    {
        txtPassword.sendKeys(password);
    }
    public void enterFirstName(String firstName)
    {
        txtFname.sendKeys(firstName);
    }

    public void enterLastName(String lastName)
    {
        txtLname.sendKeys(lastName);
    }


    public void enterCompanyName(String coName)
    {
        Company.sendKeys(coName);
    }

    public void enterAdminContent(String content)
    {
        AdminComment.sendKeys(content);
    }

	/*public void enterCustomerRoles(String role)
	{

	}*/

    public void enterManagerOfVendor(String value)
    {
        Select drp=new Select(dropdownVendorMgr);
        drp.selectByVisibleText(value);
    }

    public void enterGender(String gender)
    {
        if(gender.equals("Male"))
        {
            Gender_Male.click();
        }
        else if(gender.equals("Female"))
        {
            Gender_Female.click();
        }
        else//default set Male gender
        {
            Gender_Male.click();
        }

    }
    public void clickOnSave()
    {
        btnSave.click();
    }

}




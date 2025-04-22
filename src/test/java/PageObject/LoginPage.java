package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver ldriver;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;

    @FindBy(xpath = "//button[text()='Log in']")
    WebElement LoginButton;

    @FindBy(xpath = "//*[@id=\"navbarText\"]/ul/li[3]/a")
    WebElement LogoutButton;

    public LoginPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    public void enterEmail(String emailAdd)
    {
        email.clear();
        System.out.println("Text field cleared");
        email.sendKeys(emailAdd);
    }
    public void enterPassord(String pass)
    {
        password.clear();
        password.sendKeys(pass);
    }
    public void clickOnLoginButton()
    {
        LoginButton.click();
    }
    public void clickOnLogoutButton()
    {
        LogoutButton.click();
    }

}



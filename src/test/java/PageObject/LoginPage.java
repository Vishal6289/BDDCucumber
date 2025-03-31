package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="Email")
    WebElement email;

    @FindBy(id="Password")
    WebElement password;

    @FindBy(xpath = "//button[text()='Log in']")
    WebElement LoginButton;

    public void enterEmail(String emailAdd)
    {
        email.clear();
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

}



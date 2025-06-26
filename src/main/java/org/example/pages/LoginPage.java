package org.example.pages;
import org.example.drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.utils.Waitility;

public class LoginPage {

    public void fillUserName(String username){
        String xpath = "//div[@class='oxd-form-row']//input[@placeholder='Username']";
        WebElement fieldUsername = DriverFactory.getDriver().findElement(By.xpath(xpath));
        Waitility.waitUntilVisible(fieldUsername);
        fieldUsername.click();
        fieldUsername.sendKeys(username);
    }

    public void fillPassword(String password){
        String xpath = "//div[@class='oxd-form-row']//input[@placeholder='Password']";
        WebElement fieldPassword = DriverFactory.getDriver().findElement(By.xpath(xpath));
        Waitility.waitUntilVisible(fieldPassword);
        fieldPassword.click();
        fieldPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        String xpath = "//button[@type='submit']";
        WebElement btnLogin = DriverFactory.getDriver().findElement(By.xpath(xpath));
        Waitility.waitUntilVisible(btnLogin);
        btnLogin.click();
    }
}

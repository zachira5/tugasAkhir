package pages;

import org.openqa.selenium.By;

import static helper.Utility.driver;

public class WebPage {
    By input_username = By.id("user-name");
    By input_password = By.id("password");
    By btn_login = By.id("login-button");
    By icon_cart = By.xpath("//a[@class='shopping_cart_link']");

    public void openBrowser(){
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username){
        driver.findElement(input_username).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(input_password).sendKeys(password);
    }

    public void clickButtonLogin(){
        driver.findElement(btn_login).click();
    }

    public void assertHomePage(){
        driver.findElement(icon_cart).isDisplayed();
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    private WebDriver driver;
    private By text_username = By.id("name");
    private By text_password = By.id("password");
    private By btn_login = By.id("login");
    private By btn_logout = By.id("logout");
    public loginPage(WebDriver driver){
        this.driver= driver;
        if(!driver.getTitle().equals("TestProject Demo")){
            throw new IllegalStateException("This is not login Page.The Current page is"
                    + driver.getCurrentUrl());
        }
    }
    public void enterUsername(String username){driver.findElement(text_username).sendKeys(username);}
    public void enterPassword(String password){driver.findElement(text_password).sendKeys(password);}
    public void clickLogin(){driver.findElement(btn_login).click();}
    public boolean checkLogOutIsDisplayed(){return driver.findElement(btn_logout).isDisplayed();}
    public void loginValidUser(String username,String password){
        driver.findElement(text_username).sendKeys(username);
        driver.findElement(text_password).sendKeys(password);
        driver.findElement(btn_login).click();
    }
}

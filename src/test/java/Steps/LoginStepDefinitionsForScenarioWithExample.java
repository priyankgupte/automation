
package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class LoginStepDefinitionsForScenarioWithExample {
    private WebDriver driver;
    @Given("User is on Home Page")
    public void user_Is_On_Home_Page() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }
 @When("User Navigate to Login Page")
    public void user_Navigate_to_Login_Page () throws Throwable{
     System.out.println("user_Navigate_to_Login_Page");
    }
    @When("User enters username and password")
    public void user_enters_user_name_and_password(String username,String password)throws Throwable{
        System.out.println("user name is "+username+ "password is "+password);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button]")).click();
    }


    @Then("Message displayed Login Sucessfully")
    public void Message_displayed_Login_sucessfully() throws Throwable {
        System.out.println("Sucessfully Login");
        Thread.sleep(2000);
        driver.close();

    }
}

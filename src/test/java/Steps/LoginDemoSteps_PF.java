package Steps;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagefactory.HomePage_PF;
import pagefactory.LoginPage_PF;

import java.util.concurrent.TimeUnit;

public class LoginDemoSteps_PF {
    WebDriver driver=null;
    LoginPage_PF login;
    HomePage_PF home;
    @Given("browser is open")
    public void browser_is_open (){
        System.out.println("I am inside LoginDemoSteps_PF class");
        System.out.println("Inside Step-browser is open");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @And("user is on login page")
    public void user_is_on_login_page(){
        driver.navigate().to("https:example.testproject.io/web/");
    }
    @When("User enters {string} and{string}")
    public void user_enters_username_and_password(String username,String password)throws InterruptedException{
        login=new LoginPage_PF(driver);
        login.enterUsername(username);
        login.enterPassword(password);
        Thread.sleep(2000);
    }
    @And("user clicks on login")
    public void user_clicks_on_login(){
        login.clickOnLogin();
    }
    @Then("user is navigated to the homepage")
    public void user_is_navigated_to_the_homepage()throws InterruptedException{
        home=new HomePage_PF(driver);
        Assert.assertTrue(home.checkLogoutIsDisplayed());
        Thread.sleep(2000);
        driver.close();
        driver.quit();

    }
}

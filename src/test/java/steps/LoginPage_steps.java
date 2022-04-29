package steps;

import BaseEnv.Env;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPage_steps{
    private Env env;
    public LoginPage_steps(Env env){
        this.env = env;
    }
    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }
    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        return new ChromeDriver();
    }

    @Given("open the GoogleChrome browser and goes to Facebook page")
    public void open_the_GoogleChrome_browser_and_goes_to_Facebook_page(){
        env.loginPage.open();
        env.driver.manage().window().maximize();
        assertTrue(env.loginPage.isLoaded());
    }
    @When("user enters the password and clicks on show password button")
    public void user_enters_the_password_and_clicks_on_show_password_button(){
        env.loginPage.clickOnShowPasswordButton();
    }
    @Then("the password will be showed")
    public void the_password_will_be_showed() throws Exception {
        assertTrue(env.loginPage.assertThatPasswordIsVisible());
    }

    @When("user presses on Create user button")
    public void user_presses_on_Create_user_button(){
        env.loginPage.pressCreateUserButton();
    }
    @Then("it will open the mini tab to create the user")
    public void it_will_open_the_mini_tab_to_create_the_user(){
        env.loginPage.isMiniTabLoaded();
    }
    @When("user presses on forget password button")
    public void user_presses_on_forget_password_button(){
        env.loginPage.clickOnForgetPassButton();
    }
    @Then("it will transfer to recover page and check it if this page works")
    public void it_will_transfer_to_recover_page_and_check_it_if_this_page_works(){
        env.loginPage.transferToRecoverPage();
    }
    @When("user sees links on the bottom")
    public void user_sees_links_on_the_bottom(){
        assertEquals(env.loginPage.areLinksOnTheBottomVisible(),30);
    }
    @Then("validate all urls")
    public void validate_all_urls(){
        env.loginPage.validateAllUrls();
    }
    @When("user provides all the information")
    public void user_provides_all_the_information(){
        env.loginPage.fillAllTheInformation();
    }
    @Then("log in")
    public void log_in(){
        env.loginPage.login();
    }

}

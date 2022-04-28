package steps;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPageFeature;
import pages.MainPageFeature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static steps.Hooks.takeSnapShot;

public class MainPage_steps {
    private WebDriver driver;
    private MainPageFeature mainPage;
    private LoginPageFeature loginPage;

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        return new ChromeDriver();
    }


    @Given("the main page")
    public void the_main_page() throws InterruptedException {
        driver = getDriver();
        mainPage = new MainPageFeature(driver);
        loginPage = new LoginPageFeature(driver);
        driver.manage().window().maximize();
        loginPage.open();
        loginPage.fillAllTheInformation();
        loginPage.login();
        assertTrue(mainPage.isLoaded());
    }

    @When("clicks on more button which is on the left side of the page")
    public void clicks_on_more_button_which_is_on_the_left_side_of_the_page() throws InterruptedException {
        Thread.sleep(500);
        mainPage.clickOnMoreButton();
        Thread.sleep(500);
    }

    @Then("validate all the links")
    public void validate_all_the_links() {
        mainPage.validateLinksOnTheLeft();
    }

    @When("sees the search bar")
    public void sees_the_search_bar() {
        assertTrue(mainPage.searchBarVisible());
    }

    @Then("enter a text in bar")
    public void enter_a_text_in_bar() throws Exception {
        mainPage.enterTextInSearchBar();
        takeSnapShot(driver, ".//screenshot/searchbar.png");
    }

    @When("sees links on the top")
    public void sees_links_on_the_top() {
        assertEquals(mainPage.linksOnTheTopAreVisible(), 6);
    }

    @Then("validate all links")
    public void validate_all_links() {
        mainPage.validateLinksOnTheTop();
    }

    @When("sees the hud buttons")
    public void sees_the_hud_buttons() {
        assertTrue(mainPage.hudButtonsAreVisible());
    }

    @Then("validate all hud buttons")
    public void validate_all_hud_buttons() {
        mainPage.validateAllHudButton();
    }
}

package steps;



import BaseEnv.Env;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static steps.Hooks.takeSnapShot;

public class MainPage_steps {
    private Env env;
    public MainPage_steps(Env env){
        this.env = env;
    }
    @Given("the main page")
    public void the_main_page() throws InterruptedException {

        env.loginPage.open();
        env.driver.manage().window().maximize();
        env.loginPage.fillAllTheInformation();
        env.loginPage.login();
        assertTrue(env.mainPage.isLoaded());
    }

    @When("clicks on more button which is on the left side of the page")
    public void clicks_on_more_button_which_is_on_the_left_side_of_the_page() throws InterruptedException {
        Thread.sleep(500);
        env.mainPage.clickOnMoreButton();
        Thread.sleep(500);
    }

    @Then("validate all the links")
    public void validate_all_the_links() {
        env.mainPage.validateLinksOnTheLeft();
    }

    @When("sees the search bar")
    public void sees_the_search_bar() {
        assertTrue(env.mainPage.searchBarVisible());
    }

    @Then("enter a text in bar")
    public void enter_a_text_in_bar() throws Exception {
        env.mainPage.enterTextInSearchBar();
        takeSnapShot(env.driver, ".//screenshot/searchbar.png");
    }

    @When("sees links on the top")
    public void sees_links_on_the_top() {
        assertEquals(env.mainPage.linksOnTheTopAreVisible(), 6);
    }

    @Then("validate all links")
    public void validate_all_links() {
        env.mainPage.validateLinksOnTheTop();
    }

    @When("sees the hud buttons")
    public void sees_the_hud_buttons() {
        assertTrue(env.mainPage.hudButtonsAreVisible());
    }

    @Then("validate all hud buttons")
    public void validate_all_hud_buttons() {
        env.mainPage.validateAllHudButton();
    }
}

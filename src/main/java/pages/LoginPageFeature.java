package pages;

import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static io.restassured.RestAssured.get;
import static org.openqa.selenium.By.*;

public class LoginPageFeature extends BasePage{
    private final String loginPageUrl = "https://www.facebook.com/";
    private By createUserButton = xpath("//a[@role='button'][@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']");
    private By passwordField = id("pass");
    private By forgetPassButton = xpath("//div[@class='_6ltj']//a");
    private By userNameField = id("email");
    WebDriverWait wait;
    private Response response;

    public LoginPageFeature(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get(loginPageUrl);
    }

    public boolean isLoaded() {
        wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField)).isDisplayed();
    }

    public void clickOnShowPasswordButton() {
        driver.findElement(passwordField).sendKeys("1");
        driver.findElement(cssSelector("._9lsa")).click();
    }

    public boolean assertThatPasswordIsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//input[@type='text']"))).isDisplayed();
    }

    public void pressCreateUserButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createUserButton)).isDisplayed();
        driver.findElement(createUserButton).click();
    }

    public void isMiniTabLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(name("firstname"))).isDisplayed();
    }

    public void clickOnForgetPassButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(forgetPassButton)).isDisplayed();
        driver.findElement(forgetPassButton).click();
    }

    public void transferToRecoverPage() {
        String url = driver.getCurrentUrl();
        response = get(url);
        int status = response.getStatusCode();
        if(status == 200){
            System.out.println(status + " Recover password Page is working OK");
        }
    }

    public int areLinksOnTheBottomVisible() {
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='pageFooterChildren']//ul//li/a"));
        System.out.println("Amount of links: " + links.size());
        return links.size();
    }

    public void validateAllUrls() {
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='pageFooterChildren']//ul//li/a"));
        for(int i =0; i<links.size();i++){
            WebElement link = links.get(i);
            String url = link.getAttribute("href");
            System.out.println(url);
            verifyLinks(url);
        }
    }

    public void fillAllTheInformation() {
        driver.findElement(userNameField).sendKeys("vip.saparbaev@bk.ru");
        driver.findElement(passwordField).sendKeys("Saparbaev02");
    }

    public void login() {
        driver.findElement(By.name("login")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='main']"))).isDisplayed();
    }
}

package BaseEnv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPageFeature;
import pages.MainPageFeature;

public class Env {
    public WebDriver driver;
    public MainPageFeature mainPage;
    public LoginPageFeature loginPage;
    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        return new ChromeDriver();
    }
    public Env(){
        driver = getDriver();
        loginPage = new LoginPageFeature(driver);
        mainPage = new MainPageFeature(driver);
    }
}

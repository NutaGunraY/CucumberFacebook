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


public class MainPageFeature extends BasePage{
    private Response response;
    WebDriverWait wait;
    private By searchBar = cssSelector("div[class='rq0escxv byvelhso q10oee1b poy2od1o j9ispegn kr520xx4 ooia0uwo kavbgo14 mhnrfdw6'] div label[class='lzcic4wl gs1a9yip br7hx15l h2jyy9rg n3ddgdk9 owxd89k7 rq0escxv j83agx80 a5nuqjux l9j0dhe7 k4urcfbm kbf60n1y b3i9ofy5']");
    public MainPageFeature(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,10);
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//div[@role='main']"))).isDisplayed();
    }

    public void clickOnMoreButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ow4ym5g4 auili1gw rq0escxv j83agx80 buofh1pr g5gj957u i1fnvgqd oygrvhab cxmmr5t8 hcukyx3x kvgmc6g5 hpfvmrgz qt6c0cv9 jb3vyjys l9j0dhe7 du4w35lb bp9cbjyn btwxx1t3 dflh9lhu scb9dxdr nnctdnn4'])[7]"))).click();
    }

    public void validateLinksOnTheLeft() {
        List<WebElement> links = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//ul)[3]/li/div/a")));
        System.out.println("Amount of links: " + links.size());
        for (int i = 0; i < links.size(); i++) {
            WebElement E1 = links.get(i);
            String url = E1.getAttribute("href");
            System.out.println(url);
            response = get(url);
            int status = response.getStatusCode();
            try {
                if (status == 200) {
                    System.out.println(status + ": IS OK");
                } else {
                    System.out.println(status + " IS NOT OK");
                }

            } catch (Exception e) {
            }
        }
    }

    public boolean searchBarVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar)).isDisplayed();
    }

    public void enterTextInSearchBar() {
        driver.findElement(searchBar).sendKeys("Some text has been entered");
    }

    public int linksOnTheTopAreVisible() {
        List<WebElement> links = driver.findElements(By.xpath("(//ul[@class='thodolrn ojvp67qx taijpn5t buofh1pr j83agx80 aovydwv3 bqdfd6uv'])/li/span/div/a"));
        System.out.println("Amount of links: " + links.size());
        return links.size();
    }

    public void validateLinksOnTheTop() {
        List<WebElement> links = driver.findElements(By.xpath("(//ul[@class='thodolrn ojvp67qx taijpn5t buofh1pr j83agx80 aovydwv3 bqdfd6uv'])/li/span/div/a"));
        System.out.println("Amount of links: " + links.size());
        for (int i = 0; i < links.size(); i++) {
            WebElement link = links.get(i);
            String url = link.getAttribute("href");
            System.out.println(url);
            response = get(url);
            int status = response.getStatusCode();
            try {
                if (status == 200) {
                    System.out.println(status + ": IS OK");
                } else {
                    System.out.println(status + " IS NOT OK");
                }

            } catch (Exception e) {
            }
        }
    }

    public boolean hudButtonsAreVisible() {
        return driver.findElement(xpath("(//div[@class='bp9cbjyn j83agx80 datstx6m taijpn5t oi9244e8'])[1]")).isDisplayed();
    }

    public void validateAllHudButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("(//div[@class='bp9cbjyn j83agx80 datstx6m taijpn5t oi9244e8'])[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("(//div[@class='bp9cbjyn j83agx80 datstx6m taijpn5t oi9244e8'])[2]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("(//div[@class='bp9cbjyn j83agx80 datstx6m taijpn5t oi9244e8'])[3]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='tojvnm2t a6sixzi8 abs2jz4q a8s20v7p t1p8iaqh k5wvi7nf q3lfd5jv pk4s997a bipmatt0 cebpdrjk qowsmv63 owwhemhu dp1hu0rb dhp61c6y iyyx5f41'])[7]"))).click();
    }
}

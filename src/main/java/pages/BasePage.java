package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;

public class BasePage {
    public final WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver =driver;
    }
    public static void verifyLinks(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
            }

            //Fetching and Printing the response code obtained
            else{
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
        }
    }
}

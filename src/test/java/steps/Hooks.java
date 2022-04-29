package steps;

import BaseEnv.Env;
import io.cucumber.java.After;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class Hooks {

    private Env env;
    public Hooks(Env env){
        this.env = env;
    }
    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        return new ChromeDriver();
    }

    @Before
    public void setup(){
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
    @After
    public void afterStep(Scenario scenario){
        if(scenario.isFailed()){
            System.out.println(scenario.getStatus());
        }
        env.driver.quit();
    }
}

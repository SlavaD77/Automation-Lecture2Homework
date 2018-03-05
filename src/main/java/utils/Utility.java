package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.Properties;


public class Utility {
    public static Properties getProperties(){

        Properties property = new Properties();

        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")){
            property.load(fis);
        } catch (IOException e) {
            System.err.println("Error, config.properties is absent!");
            System.exit(0);
        }
        return property;
    }

    public static void waiting(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        }
        catch(InterruptedException e){
            System.err.println("Exception in Thread.sleep");
        }
    }

    public static void waiting(){
        waiting(1000);}

    public static WebDriver initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}

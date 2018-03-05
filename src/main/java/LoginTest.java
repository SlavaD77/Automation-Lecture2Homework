import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utility;

import java.util.Properties;


public class LoginTest {
    public static void main(String[] args) {
        WebDriver driver = Utility.initChromeDriver();

        loginToAdminPanel(driver);

        Utility.waiting();

        WebElement userAvatar = driver.findElement(By.id("header_employee_box"));
        userAvatar.click();

        Utility.waiting();

        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();

//        driver.quit();
    }

    public static void loginToAdminPanel(WebDriver driver){

        Properties properties = Utility.getProperties();

        driver.navigate().to(properties.getProperty("address"));

        WebElement login = driver.findElement(By.id("email"));

        WebElement password = driver.findElement(By.id("passwd"));

        WebElement submit = driver.findElement(By.name("submitLogin"));

        login.sendKeys(properties.getProperty("login"));

        password.sendKeys(properties.getProperty("password"));

        submit.click();
    }

}

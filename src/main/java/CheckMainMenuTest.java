import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class CheckMainMenuTest {
    
    public static void main(String[] args) {
 
        WebDriver driver = Utility.initChromeDriver();

        LoginTest.loginToAdminPanel(driver);

        Utility.waiting(1000);
        
        String title;

        //Get all main menu items
        List<WebElement> menuItems = driver.findElements(By.className("maintab"));

        List<String> attributeValues = new ArrayList<>();

        //Get value of data-submenu attribute for all main menu items
        for (WebElement element: menuItems) {
            attributeValues.add(element.getAttribute("data-submenu"));
        }


        for (String value: attributeValues) {
            String selector = "li[data-submenu='" + value + "']";
            WebElement element = driver.findElement(By.cssSelector(selector));
            element.click();
            Utility.waiting(1000);
            title = driver.getTitle();
            System.out.println(title);
            driver.navigate().refresh();
            Utility.waiting(1000);
            if (title.equals(driver.getTitle())) {
                System.out.println("Refresh - OK ");
            }
            else {
                System.out.println("Refresh - Failed " + driver.getTitle());
            }
        }



    }
}

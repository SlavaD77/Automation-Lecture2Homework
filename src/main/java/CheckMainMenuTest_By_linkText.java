import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckMainMenuTest_By_linkText {
    
    public static void main(String[] args) {
 
        WebDriver driver = Utility.initChromeDriver();

        LoginTest.loginToAdminPanel(driver);

        Utility.waiting(1000);
        
        String title;

        //Get all main menu items
        List<WebElement> menuItems = driver.findElements(By.className("maintab"));

        List<String> linkTexts = new ArrayList<>();

        //Get link text for all main menu items
        for (WebElement element: menuItems) {
            linkTexts.add(element.getText());
        }


        for (String text: linkTexts) {
            WebElement element = driver.findElement(By.linkText(text));
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

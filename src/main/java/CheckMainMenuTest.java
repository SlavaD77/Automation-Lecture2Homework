import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckMainMenuTest {
    
    public static void main(String[] args) {
 
        WebDriver driver = Utility.initChromeDriver();

        LoginTest.loginToAdminPanel(driver);

        Utility.waiting(1000);
        
        String title;

        //List<WebElement> menuItems = driver.findElements(By.className("maintab"));

        List<String> itemsId;
        itemsId = new ArrayList<String>(Arrays.asList(
                "tab-AdminDashboard",
                "subtab-AdminParentOrders",
                "subtab-AdminCatalog",  //!!!
                "subtab-AdminParentCustomer",
                "subtab-AdminParentCustomerThreads",
                "subtab-AdminStats",
                "subtab-AdminParentModulesSf",  //!!!
                "subtab-AdminParentThemes",
                "subtab-AdminParentShipping",
                "subtab-AdminParentPayment",
                "subtab-AdminInternational",
                "subtab-ShopParameters",
                "subtab-AdminAdvancedParameters"
                ));

        for (String id: itemsId) {
            WebElement element = driver.findElement(By.id(id));
            element.click();
            Utility.waiting(1000);
            title = driver.getTitle();
            System.out.println(title);
            //driver.navigate().refresh();
            Utility.waiting(1000);
            if (title.equals(driver.getTitle())) {
                System.out.println("Refresh - OK ");
            }
            else {
                System.out.println("Refresh - Failed " + driver.getTitle());
            }
            driver.findElement(By.linkText("Dashboard")).click();
        }



    }
}

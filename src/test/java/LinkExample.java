import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void setup() {


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/link.xhtml");
    }

    @Test
    public void LinkTests() {
        // 01) Take me to dashboard
        WebElement homelink = driver.findElement(By.linkText("Go to Dashboard"));
        homelink.click();
        driver.navigate().back();

        // 02) Find my destination
        WebElement whereToGo = driver.findElement(By.partialLinkText("Find the URL without"));
        String path = whereToGo.getAttribute("href");
        System.out.println("This link goes to: " + path);

        // 03) Broken or not
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();
        String title = driver.getTitle();
        if (title.contains("404")) {
            System.out.println("Broken link");
        } else {
            System.out.println("Not broken");
        }
        driver.navigate().back();

        // 04) Duplicate link
        WebElement homelink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homelink1.click();
        driver.navigate().back();

        // 05) Count page links
        List<WebElement> countlinks = driver.findElements(By.tagName("a"));
        int pageLinkCount = countlinks.size();
        System.out.println("Number of links on the page: " + pageLinkCount);
        driver.quit();

        // 06) Count layout links
        // You can add more logic to differentiate layout links if needed.
    }
}

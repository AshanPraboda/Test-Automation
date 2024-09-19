import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/button.xhtml");
    }

    @Test
    public void buttonTest(){
//        01 click and confirm title
        WebElement clickId = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
        clickId.click();

        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("title is matched");
        }else {
            System.out.println("title is not matched");
        }

//        02 find the element of submit button
        driver.navigate().back();
        WebElement getPoint = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt94']"));
        Point xyPoint = getPoint.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("x position is "+x +" Y position is "+y );

//        03 find the save button color
        WebElement getColor = driver.findElement(By.id("j_idt88:j_idt96"));
        String buttonColor = getColor.getCssValue("background-color");
        System.out.println("Button color is " +buttonColor);

    }

}

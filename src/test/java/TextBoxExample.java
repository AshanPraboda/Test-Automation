import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("128");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://leafground.com/input.xhtml");
    }

    @Test
    public void TextBoxTest(){
//        01) type the name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
                name.sendKeys("Ashan Praboda");

//        02)Append country to this city
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("India");

//        03 verify box disable
        boolean enable = driver.findElement(By.id("j_idt88:j_idt93")) .isEnabled();
        System.out.println("is text box enable"+ enable);

//        04)clear the type text
        WebElement CleartypeText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        CleartypeText.clear();


//        05)Retrive the typed text
        WebElement typedText = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = typedText.getAttribute("value");
        System.out.println("value n the textbox is- "+ value);

//        06)type email and tab then go to next
        WebElement tab = driver.findElement(By.id("j_idt88:j_idt99")) ;
        tab.sendKeys("ashan@ggmail.com" + Keys.TAB + "Confirmed that goes to next");

    }
}

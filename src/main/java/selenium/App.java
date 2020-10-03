package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class App {
    private static final String OS_WINDOWS = "win";
    private static final String OS_MAC = "osx";
    private static final String OS_LINUX = "linux";
    static final String nameValue = "Liang";
    static final String descriptionValue = "Environemental effect";
    static final String nameField = "#name";
    static final String descriptionField = "#description";
    
    public static String getGreeting(){
        return "Hello World";
    }

    public static void main(String[] args) {
        setUpChromeDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String resName, resDesc;
       try {
            driver.get("http://localhost:3000/");
            WebElement button = driver.findElement(By.cssSelector("a"));
            button.click();
            WebElement name = driver.findElement(By.cssSelector(nameField));
            name.sendKeys(nameValue);
            WebElement desc = driver.findElement(By.cssSelector(descriptionField));
            desc.sendKeys(descriptionValue);
            WebElement send = driver.findElement(By.cssSelector("button"));
            send.click();
            List<WebElement> items = driver.findElements(By.cssSelector("li"));

            resName = items.get(0).findElement(By.cssSelector("h5")).getText();
            resDesc = items.get(0).findElement(By.cssSelector(".description")).getText();
        } finally {
            driver.quit();
        }

        System.out.println(resName + " " + resDesc);
    }

    public static void setUpChromeDriver() {
        String os = System.getProperty("os.name").toLowerCase();
        StringBuffer driverPath = new StringBuffer();
        driverPath.append("./ressource/");
        if(os.contains(OS_WINDOWS)) {
            driverPath.append("chromedriver-" + OS_WINDOWS + ".exe");
        } else if (os.contains(OS_MAC)){
            driverPath.append("chromedriver-" + OS_MAC);
        } else if (os.contains(OS_LINUX)){
            driverPath.append("chromedriver-" + OS_LINUX);
        }

        System.setProperty("webdriver.chrome.driver", driverPath.toString());
    }
}
  
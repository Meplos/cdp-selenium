package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.io.File;
import java.time.Duration;

public class App {
    private static final String OS_WINDOWS = "win";
    private static final String OS_MAC = "osx";
    private static final String OS_LINUX = "linux";


    public static void main(String[] args) {
        
        setUpChromeDriver();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        try {
            driver.get("https://google.com/");
            driver.findElement(By.name("q")).sendKeys("facebook" + Keys.ENTER);
            WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
            System.out.println(firstResult.getAttribute("textContent"));
        } finally {
            driver.quit();
        }
    }

    private static void setUpChromeDriver() {
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
  
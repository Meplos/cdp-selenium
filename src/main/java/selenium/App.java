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

    public static String getGreeting(){
        return "Hello World";
    }

    public static void main(String[] args) {
        System.out.println(getGreeting());
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
  
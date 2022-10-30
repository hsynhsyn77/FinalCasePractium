package Utility;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenelWebdriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void startingOperations() {
        System.out.println("========= Test start =========");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.hepsiburada.com/");

        KalanOncekileriKapat();

    }

    @AfterClass
    public void BitisIslemleri() {
        System.out.println("========Test Ended =========");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

    public static void KalanOncekileriKapat() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver /T");
        } catch (Exception ignored) {

        }
    }
}





